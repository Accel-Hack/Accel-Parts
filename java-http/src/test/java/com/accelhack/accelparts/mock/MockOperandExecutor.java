package com.accelhack.accelparts.mock;

import com.accelhack.accelparts.Request;
import com.accelhack.accelparts.ResponseSet;
import com.accelhack.accelparts.executor.OperandExecutor;
import com.accelhack.accelparts.Operand;

import javax.validation.Validator;

public class MockOperandExecutor extends OperandExecutor {

  @Override
  public Object execute(Operand operand) {
    return null;
  }

  @Override
  public ResponseSet run(Request request, Validator validator) {
    return super.run(request, validator);
  }
}
