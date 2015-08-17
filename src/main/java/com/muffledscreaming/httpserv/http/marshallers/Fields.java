package com.muffledscreaming.httpserv.http.marshallers;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Fields {
  public static final String FIELD_ASSIGNMENT = ": ";

  private String rawFields;

  private HashMap marshalled = null;

  public Fields(String rawFields) {
    this.rawFields = rawFields;
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
      Arrays.asList(rawFields.split(getDelimiter()))
    );
    fieldList.removeAll(new ArrayList<String>() {{ add(""); }});

    return fieldList;
  }

  private String getKey(String line) {
    return line.split(FIELD_ASSIGNMENT)[0];
  }

  private String getValue(String line) {
    return line.split(FIELD_ASSIGNMENT)[1];
  }

  private String getDelimiter() {
    return com.muffledscreaming.httpserv.http.extractors.Fields.FIELD_DELIMITER;
  }
}
