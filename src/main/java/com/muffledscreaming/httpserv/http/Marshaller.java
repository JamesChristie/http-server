package com.muffledscreaming.httpserv.http;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Marshaller {
  public static final String FIELD_ASSIGNMENT = ": ";
  public static final String PARAM_ASSIGNMENT = "=";

  private String rawFields;
  private String delimiter;
  private String assignment;

  private HashMap marshalled = null;

  public Marshaller(String rawFields, String delimiter, String assignment) {
    this.rawFields  = rawFields;
    this.delimiter  = delimiter;
    this.assignment = assignment;
  }

  public HashMap<String,String> marshall() {
    if (marshalled == null) { separateFields(); }
    return marshalled;
  }

  private void separateFields() {
    this.marshalled = new HashMap<String,String>();

    for (String line : getFieldList()) {
      marshalled.put(getKey(line), getValue(line));
    }
  }

  private List<String> getFieldList() {
    List<String> fieldList = new ArrayList<String>();
    fieldList.addAll(
      Arrays.asList(rawFields.split(delimiter))
    );
    fieldList.removeAll(new ArrayList<String>() {{ add(""); }});

    return fieldList;
  }

  private String getKey(String line) {
    return line.split(assignment)[0];
  }

  private String getValue(String line) {
    return line.split(assignment)[1];
  }
}
