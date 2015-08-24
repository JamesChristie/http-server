package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class NoContent extends Response {
  public String getStatusCode() {
    return "204";
  }

  public String getStatusMessage() {
    return "No Content";
  }
}
