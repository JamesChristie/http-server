package com.muffledscreaming.httpserv.exception;

public class ReadException extends HttpservException {
  public ReadException(String message) {
    super(message);
  }

  public ReadException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
