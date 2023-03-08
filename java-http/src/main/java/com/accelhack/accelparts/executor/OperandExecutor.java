package com.accelhack.accelparts.executor;

import com.accelhack.accelparts.*;
import com.google.common.collect.Streams;

import javax.validation.Validator;
import java.util.List;
import java.util.Objects;

public abstract class OperandExecutor<O extends Operand, Res> {
  public abstract Res execute(O operand);

  public ResponseSet<Res> run(Request<O> request, Validator validator, Class<?>... groups) {
    ResponseSet<Res> errorResponseSet = request.validate(validator, groups);
    if (Objects.nonNull(errorResponseSet)) return errorResponseSet;
    List<Response<Res>> results = Streams.mapWithIndex(
      request.getOperands().stream(),
      (operand, index) -> Response.withResult(index, execute(operand))).toList();
    return ResponseSet.ok(results.size(), results);
  }
}
