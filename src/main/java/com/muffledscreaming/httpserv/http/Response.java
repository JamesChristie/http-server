package com.muffledscreaming.httpserv.http;

import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

public abstract class Response {
  private static final String DEFAULT_VERSION = "1.1";

  protected String version;
  protected String body;
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

  public String getBody() {
    return body;
  }

  public void setHeader(String header, String value) {
    headers.put(header, value);
  }

  public void setBody(String body) {
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
