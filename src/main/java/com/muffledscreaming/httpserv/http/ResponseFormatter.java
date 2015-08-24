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
      "HTTP/%s %s %s%s%s",
      response.getVersion(),
      response.getStatusCode(),
      response.getStatusMessage(),
      formatHeaders(),
      formatBody()
    );
  }

  private String formatHeaders() {
    String headers = joinHeaders();
    if(headers.isEmpty()) { return ""; }
    else { return "\r\n" + headers; }
  }

  private String joinHeaders() {
    List<String> pairedHeaders = new ArrayList<String>();

    for (String header : (List<String>)response.alphabatizedHeaders()) {
      pairedHeaders.add(
        String.format("%s: %s", header, response.getHeaderValue(header))
      );
    }

    return String.join("\r\n", pairedHeaders);
  }

  private String formatBody() {
    if (response.getBody() == null) {
      return "";
    } else {
      return "\r\n\r\n" + response.getBody();
    }
  }
}
