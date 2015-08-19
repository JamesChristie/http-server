package com.muffledscreaming.httpserv.http;

import java.util.List;
import java.util.ArrayList;

public class ResponseFormatter {
  private Response response;

  public ResponseFormatter(Response response) {
    this.response = response;
  }

  public String perform() {
    return String.format(
      "HTTP/%s %s %s\r\n%s\r\n\r\n%s",
      response.getVersion(),
      response.getStatusCode(),
      response.getStatusMessage(),
      formatHeaders(),
      response.getBody()
    );
  }

  private String formatHeaders() {
    List<String> pairedHeaders = new ArrayList<String>();

    for (String header : (List<String>)response.alphabatizedHeaders()) {
      pairedHeaders.add(
        String.format("%s: %s", header, response.getHeaderValue(header))
      );
    }

    return String.join("\r\n", pairedHeaders);
  }
}
