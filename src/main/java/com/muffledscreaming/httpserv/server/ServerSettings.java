package com.muffledscreaming.httpserv.server;

import com.muffledscreaming.httpserv.util.ArgParser;

public class ServerSettings {
  public static final int DEFAULT_PORT    = 8080;
  public static final String DEFAULT_PATH = System.getProperty("user.dir");

  private ArgParser parser;

  public ServerSettings(ArgParser parser) {
    this.parser = parser;
  }

  public int getPort() {
    String portString = parser.getValueForOption("p");

    if (portString.isEmpty()) {
      return DEFAULT_PORT;
    } else {
      return Integer.parseInt(portString);
    }
  }

  public String getPublicPath() {
    String pathString = parser.getValueForOption("d");

    if (pathString.isEmpty()) {
      return DEFAULT_PATH;
    } else {
      return pathString;
    }
  }
}
