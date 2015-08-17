package com.muffledscreaming.httpserv.http.marshallers;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Params {
  public static final String PARAM_ASSIGNMENT = "=";

  private String rawParams;

  private HashMap marshalled = null;

  public Params(String rawParams) {
    this.rawParams = rawParams;
  }

  public HashMap<String,String> marshall() {
    if (marshalled == null) { separateParams(); }
    return marshalled;
  }

  private void separateParams() {
    this.marshalled = new HashMap<String,String>();

    for (String line : getParamList()) {
      marshalled.put(getKey(line), getValue(line));
    }
  }

  private List<String> getParamList() {
    List<String> fieldList = new ArrayList<String>();
    fieldList.addAll(
      Arrays.asList(rawParams.split(getDelimiter()))
    );
    fieldList.removeAll(new ArrayList<String>() {{ add(""); }});

    return fieldList;
  }

  private String getKey(String line) {
    return line.split(PARAM_ASSIGNMENT)[0];
  }

  private String getValue(String line) {
    return line.split(PARAM_ASSIGNMENT)[1];
  }

  private String getDelimiter() {
    return com.muffledscreaming.httpserv.http.extractors.Params.PARAM_DELIMITER;
  }
}
