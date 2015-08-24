package com.muffledscreaming.httpserv.exception;

import com.muffledscreaming.httpserv.server.Handler;

public class HandlerError extends HttpservException {
  private Handler handler;

  public HandlerError(String message, Handler handler) {
    super(message);
    this.handler = handler;
  }
}
