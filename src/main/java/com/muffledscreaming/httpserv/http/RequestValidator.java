package com.muffledscreaming.httpserv.http;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class RequestValidator {
  private static final Set validMethods = new HashSet(
    Arrays.asList(new String[] {
      Strings.OPTIONS_METHOD,
      Strings.GET_METHOD,
      Strings.HEAD_METHOD,
      Strings.POST_METHOD,
      Strings.PUT_METHOD,
      Strings.DELETE_METHOD,
      Strings.TRACE_METHOD,
      Strings.CONNECT_METHOD,
      Strings.PATCH_METHOD
    })
  );

  private static final Set validVersions = new HashSet(
    Arrays.asList(new String[] {"1.0", "1.1", "2.0"})
  );

  private Request request;

  public static boolean isValid(Request request) {
    return new RequestValidator(request).isValid();
  }

  public RequestValidator(Request request) {
    this.request = request;
  }

  public boolean isValid() {
    return requiredComponentsArePresent() &&
      methodIsValid() &&
      versionIsValid() &&
      hostIsValid();
  }

  public boolean requiredComponentsArePresent() {
    return !request.getMethod().isEmpty() &&
      !request.getPath().isEmpty() &&
      !request.getVersion().isEmpty();
  }

  public boolean methodIsValid() {
    return validMethods.contains(request.getMethod().toUpperCase());
  }

  public boolean versionIsValid() {
    return validVersions.contains(request.getVersion());
  }

  public boolean hostIsValid() {
    for (String field : (Set<String>)request.getFields()) {
      if (field.toLowerCase().equals(Request.HOST_FIELD)) {
        return !request.getFieldValue(field).isEmpty();
      }
    }

    return false;
  }
}
