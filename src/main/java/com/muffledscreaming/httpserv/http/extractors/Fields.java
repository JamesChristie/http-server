package com.muffledscreaming.httpserv.http.extractors;

import java.util.List;
import java.util.Arrays;

import com.muffledscreaming.httpserv.util.Regexer;

public class Fields {
  public static final String FIELD_DELIMITER = "\r\n";

  private String requestString;

  private List<String> allFields = null;

  public Fields(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    if (!getAllFields().isEmpty()) {
      return String.join(FIELD_DELIMITER, getAllFields());
    } else {
      return "";
    }
  }

  private List<String> getAllFields() {
    if (allFields == null) {
      this.allFields = Arrays.asList(
        Regexer.getAllMatches(requestString, "[a-zA-Z]+:(.*)(?=\r\n)")
      );
    }

    return allFields;
  }
}
