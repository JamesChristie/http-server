package com.muffledscreaming.httpserv.http;

import java.util.HashMap;
import java.util.Set;

public class Request {
  public static final String METHOD_KEY  = "method";
  public static final String PATH_KEY    = "path";
  public static final String VERSION_KEY = "version";
  public static final String PORT_KEY    = "port";
  public static final String BODY_KEY    = "body";

  public static final String HOST_FIELD = "host";

  private HashMap<String,String> comprehension;
  private HashMap<String,String> fields;
  private HashMap<String,String> params;

  public Request(HashMap comprehension, HashMap fields, HashMap params) {
    this.comprehension = comprehension;
    this.fields        = fields;
    this.params        = params;
  }

  public String getMethod() {
    return getComprehension(METHOD_KEY);
  }

  public String getPath() {
    return getComprehension(PATH_KEY);
  }

  public String getVersion() {
    return getComprehension(VERSION_KEY);
  }

  public String getPort() {
    return getComprehension(PORT_KEY);
  }

  public String getBody() {
    return getComprehension(BODY_KEY);
  }

  public Set getFields() {
    return fields.keySet();
  }

  public Set getParams() {
    return params.keySet();
  }

  public String getFieldValue(String field) {
    return fields.getOrDefault(field, "");
  }

  public String getParamValue(String param) {
    return params.getOrDefault(param, "");
  }

  private String getComprehension(String key) {
    return comprehension.getOrDefault(key, "");
  }
}
