package com.muffledscreaming.httpserv.exception;

import com.muffledscreaming.httpserv.http.Request;

public class InvalidRequest extends HttpservException {
  private Request request;

  public InvalidRequest(String message, Request request) {
    super(message);
    this.request = request;
  }
}
