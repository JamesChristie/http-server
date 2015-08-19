package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class BadRequest extends Response {
  public String getStatusCode() {
    return "400";
  }

  public String getStatusMessage() {
    return "Bad Request";
  }
}
