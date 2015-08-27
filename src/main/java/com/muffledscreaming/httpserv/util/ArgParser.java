package com.muffledscreaming.httpserv.util;

import java.util.List;
import java.util.Arrays;

public class ArgParser {
  private List<String> args;

  public ArgParser(String[] args) {
    this.args = Arrays.asList(args);
  }

  public boolean optionPresent(String option) {
    return getPosition(option) != -1;
  }

  public String getValueForOption(String option) {
    if (optionPresent(option)) {
      return valueForArgPosition(getPosition(option));
    } else { return ""; }
  }

  private int getPosition(String option) {
    String shortArg = shortArg(option);
    String longArg  = longArg(option);

    if (args.contains(shortArg)) { return args.indexOf(shortArg); }
    else if (args.contains(longArg)) { return args.indexOf(longArg); }
    else { return -1; }
  }

  private String valueForArgPosition(int index) {
    int valueIndex = index + 1;

    if (valueIndex >= 0 && valueIndex < args.size()) {
      return args.get(valueIndex);
    } else { return ""; }
  }

  private String shortArg(String option) {
    return "-" + option;
  }

  private String longArg(String option) {
    return "--" + option;
  }
}
