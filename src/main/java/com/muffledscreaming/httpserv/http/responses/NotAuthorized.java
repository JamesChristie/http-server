package com.muffledscreaming.httpserv.http.responses;

import com.muffledscreaming.httpserv.http.Response;

public class NotAuthorized extends Response {
  public String getStatusCode() {
    return "401";
  }

  public String getStatusMessage() {
    return "Not Authorized";
  }

  public String getBody() {
    return "Authentication required";
  }
}
