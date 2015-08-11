package com.muffledscreaming.httpserv.http.extractors;

import com.muffledscreaming.httpserv.util.Regexer;

public class Version {
  private String requestString;

  public Version(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    return Regexer.getFirstMatch(requestString, "(?i)(?<=HTTP\\/)\\d(.\\d)?");
  }
}
