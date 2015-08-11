package com.muffledscreaming.httpserv.http.extractors;

import com.muffledscreaming.httpserv.util.Regexer;

public class Path {
  private String requestString;

  public Path(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    return Regexer.getFirstMatch(requestString, "(?<= )\\/[a-zA-Z\\/.]*");
  }
}
