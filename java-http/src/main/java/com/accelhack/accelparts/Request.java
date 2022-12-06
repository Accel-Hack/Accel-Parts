package com.accelhack.accelparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Streams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request<E extends Operand> {
  private Long timestamp = new Date().getTime();
  @NonNull
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<E> operands;

  public E findFirst() {
    return operands.stream().findFirst().orElseThrow();
  }

  public <T> ResponseSet<T> validate(Validator validator) {
    List<ResponseError> requestErrors = validator.validate(this)
      .stream().map(error -> ResponseError.build("key", operands, "CODE")).collect(Collectors.toList());
    if (!requestErrors.isEmpty()) {
      return (new ResponseSet.Builder<T>())
        .status(HttpStatus.OK)
        .errors(requestErrors)
        .build();
    }

    List<Response<T>> responses = Streams.mapWithIndex(operands.stream(),
      (operand, index) -> {
        Set<ConstraintViolation<Operand>> operandErrors = validator.validate(operand);
        if (operandErrors.isEmpty()) {
          return null;
        }

        List<ResponseError> responseErrors = operandErrors.stream().map(error ->
            ResponseError.build(
              error.getPropertyPath().toString(),
              error.getInvalidValue(),
              error.getMessage()))
          .collect(Collectors.toList());
        return (new Response.Builder<T>())
          .operationKey(Math.toIntExact(index))
          .operationStatus(false)
          .errors(responseErrors)
          .build();
      }
    ).filter(Objects::nonNull).collect(Collectors.toList());

    if (!responses.isEmpty()) {
      return ResponseSet.ok(responses.size(), responses);
    }
    return null;
  }

  public <T> ResponseSet<T> validate() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    return this.validate(validator);
  }

  public Stream<E> toStream() {
    return getOperands().stream();
  }
}
