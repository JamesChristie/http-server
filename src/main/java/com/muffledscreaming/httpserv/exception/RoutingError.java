package com.muffledscreaming.httpserv.exception;

import com.muffledscreaming.httpserv.http.Request;

public class RoutingError extends HttpservException {
  private String routeKey;

  public RoutingError(String message, String routeKey) {
    super(message);
    this.routeKey = routeKey;
  }
}
