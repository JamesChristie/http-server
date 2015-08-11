package com.muffledscreaming.httpserv.http.extractors;

import com.muffledscreaming.httpserv.util.Regexer;

public class Port {
  public static final String DEFAULT_PORT = "80";

  private String requestString;

  public Port(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    String port = Regexer.getFirstMatch(requestString, "(?<=:)\\d+");

    if (!requestString.isEmpty() && port.isEmpty()) {
      return DEFAULT_PORT;
    } else {
      return port;
    }
  }
}
