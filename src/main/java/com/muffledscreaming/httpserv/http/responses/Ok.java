package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class Ok extends Response {
  public String getStatusCode() {
    return "200";
  }

  public String getStatusMessage() {
    return "OK";
  }
}
