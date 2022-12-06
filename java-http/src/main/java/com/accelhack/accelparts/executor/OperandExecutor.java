package com.accelhack.accelparts.executor;

import com.accelhack.accelparts.Request;
import com.accelhack.accelparts.ResponseSet;
import com.google.common.collect.Streams;
import com.accelhack.accelparts.Operand;
import com.accelhack.accelparts.Response;

import javax.validation.Validator;
import java.util.List;
import java.util.Objects;

public abstract class OperandExecutor<O extends Operand, R> {
  public abstract R execute(O operand);

  public ResponseSet<R> run(Request<O> request, Validator validator) {
    ResponseSet<R> errorResponseSet = request.validate(validator);
    if (Objects.nonNull(errorResponseSet)) return errorResponseSet;
    List<Response<R>> results = Streams.mapWithIndex(
      request.getOperands().stream(),
      (operand, index) -> Response.withResult(index, execute(operand))).toList();
    return ResponseSet.ok(results.size(), results);
  }
}
