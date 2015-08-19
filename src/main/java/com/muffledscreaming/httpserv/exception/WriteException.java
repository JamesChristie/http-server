package com.muffledscreaming.httpserv.exception;

public class WriteException extends HttpservException {
  public WriteException(String message) {
    super(message);
  }

  public WriteException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
