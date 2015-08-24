package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class Redirect extends Response {
  public String getStatusCode() {
    return "302";
  }

  public String getStatusMessage() {
    return "Found";
  }
}
