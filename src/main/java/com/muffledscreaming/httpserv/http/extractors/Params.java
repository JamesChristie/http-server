package com.muffledscreaming.httpserv.http.extractors;

import com.muffledscreaming.httpserv.util.Regexer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Params {
  public static final String PARAM_DELIMITER = "&";

  private String requestString;

  private List<String> allParams = null;

  public Params(String requestString) {
    this.requestString = requestString;
  }

  public String extract() {
    if (!getAllParams().isEmpty()) {
      return String.join(PARAM_DELIMITER, getAllParams());
    } else {
      return "";
    }
  }

  private List<String> getAllParams() {
    if (allParams == null) {
      this.allParams = Stream.concat(
        getGetParams().stream(), getBodyParams().stream()
      ).collect(Collectors.toList());

      allParams.removeAll(new ArrayList<String>() {{ add(""); }});
    }

    return allParams;
  }

  private List<String> getGetParams() {
    String params = Regexer.getFirstMatch(requestString, "(?<=\\?)[\\S]+");
    return Arrays.asList(params.split(PARAM_DELIMITER));
  }

  private List<String> getBodyParams() {
    String params = Regexer.getFirstMatch(requestString, "(?<=\r\n\r\n)(.*)");
    return Arrays.asList(params.split(PARAM_DELIMITER));
  }
}
