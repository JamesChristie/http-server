package com.muffledscreaming.httpserv.http;

import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public abstract class Response {
  private static final String DEFAULT_VERSION = "1.1";

  protected String version;
  protected InputStream body;
  protected HashMap<String,String> headers;

  public Response() {
    this.headers = new HashMap<String,String>();
    this.version = DEFAULT_VERSION;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public abstract String getStatusCode();

  public abstract String getStatusMessage();

  public InputStream getBody() {
    if (body != null) {
      return body;
    } else {
      return new ByteArrayInputStream("".getBytes(StandardCharsets.UTF_8));
    }
  }

  public void setHeader(String header, String value) {
    headers.put(header, value);
  }

  public void setBody(String body) {
    this.body = new ByteArrayInputStream(
      body.getBytes(StandardCharsets.UTF_8)
    );
  }

  public void setBody(InputStream body) {
    this.body = body;
  }

  public String getHeaderValue(String header) {
    return headers.getOrDefault(header, "");
  }

  public List alphabatizedHeaders() {
    Set<String> headerSet = headers.keySet();
    return headerSet.stream().sorted().collect(Collectors.toList());
  }
}
