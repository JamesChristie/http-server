package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class InternalServerError extends Response {
  public String getStatusCode() {
    return "500";
  }

  public String getStatusMessage() {
    return "Internal Server Error";
  }
}
