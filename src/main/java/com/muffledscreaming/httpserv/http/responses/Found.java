package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class Found extends Response {
  public String getStatusCode() {
    return "302";
  }

  public String getStatusMessage() {
    return "Found";
  }
}
