package com.muffledscreaming.httpserv.http;

import java.util.HashMap;

public class Request {
  public static final String METHOD_KEY  = "method";
  public static final String PATH_KEY    = "path";
  public static final String VERSION_KEY = "version";
  public static final String PORT_KEY    = "port";
  public static final String BODY_KEY    = "body";

  public static final String HOST_KEY    = "host";

  private HashMap<String,String> extractedRequest;
  private HashMap<String,String> fields;
  private HashMap<String,String> params;

  public Request(HashMap extractedRequest, HashMap fields, HashMap params) {
    this.extractedRequest = extractedRequest;
  }
}
