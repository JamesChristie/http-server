package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class NotFound extends Response {
  public String getStatusCode() {
    return "404";
  }

  public String getStatusMessage() {
    return "Not Found";
  }
}
