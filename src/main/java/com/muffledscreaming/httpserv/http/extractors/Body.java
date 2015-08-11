package com.muffledscreaming.httpserv.http.extractors;

import com.muffledscreaming.httpserv.util.Regexer;

public class Body {
  private String requestString;

  public Body(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    return Regexer.getFirstMatch(requestString, "(?<=\r\n\r\n)(.*)");
  }
}
