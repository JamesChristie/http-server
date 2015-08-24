package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class MethodNotAllowed extends Response {
  public String getStatusCode() {
    return "405";
  }

  public String getStatusMessage() {
    return "Method Not Allowed";
  }
}
