package com.muffledscreaming.httpserv.http.extractors;

import com.muffledscreaming.httpserv.util.Regexer;

public class Method {
  private String requestString;

  public Method(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    return getMethodSubstring().toUpperCase();
  }

  private String getMethodSubstring() {
    return Regexer.getFirstMatch(requestString, "^[a-zA-Z]*");
  }
}
