package com.accelhack.accelparts.executor;

import com.accelhack.accelparts.ResponseSet;
import com.accelhack.accelparts.Response;

import java.util.List;

public abstract class RequestExecutor<R> {
  public abstract R execute();

  public ResponseSet<R> run() {
    return ResponseSet.ok(1, List.of(Response.withResult(0, execute())));
  }
}
