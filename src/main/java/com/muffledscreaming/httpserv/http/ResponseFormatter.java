package com.muffledscreaming.httpserv.http;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.nio.charset.StandardCharsets;

public class ResponseFormatter {
  private Response response;

  public ResponseFormatter(Response response) {
    this.response = response;
  }

  public SequenceInputStream perform() {
    return new SequenceInputStream(
      getHeaderStream(),
      response.getBody()
    );
  }

  private ByteArrayInputStream getHeaderStream() {
    return new ByteArrayInputStream(
      getHeaderString().getBytes(StandardCharsets.UTF_8)
    );
  }

  private String getHeaderString() {
    return String.format(
      "HTTP/%s %s %s%s\r\n\r\n",
      response.getVersion(),
      response.getStatusCode(),
      response.getStatusMessage(),
      formatHeaders()
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
}
