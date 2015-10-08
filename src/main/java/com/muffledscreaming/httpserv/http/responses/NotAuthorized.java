package com.muffledscreaming.httpserv.http.responses;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import com.muffledscreaming.httpserv.http.Response;

public class NotAuthorized extends Response {
  public String getStatusCode() {
    return "401";
  }

  public String getStatusMessage() {
    return "Not Authorized";
  }

  public InputStream getBody() {
    return new ByteArrayInputStream(
      "Authentication required".getBytes(StandardCharsets.UTF_8)
    );
  }
}
