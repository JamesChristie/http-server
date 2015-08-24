package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class PartialContent extends Response {
  public String getStatusCode() {
    return "206";
  }

  public String getStatusMessage() {
    return "Partial Content";
  }
}
