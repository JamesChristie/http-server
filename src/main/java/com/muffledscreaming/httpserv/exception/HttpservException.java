package com.muffledscreaming.httpserv.exception;

public class HttpservException extends Exception {
  public HttpservException(String message) {
    super(message);
  }

  public HttpservException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
