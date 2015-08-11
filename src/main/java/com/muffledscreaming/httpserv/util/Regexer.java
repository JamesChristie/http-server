package com.muffledscreaming.httpserv.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class Regexer {
  public static String getFirstMatch(String subject, String pattern) {
    String[] matches = getSubstringsMatching(subject, pattern);

    if(matches.length > 0) {
      return matches[0];
    } else {
      return "";
    }
  }

  public static String[] getAllMatches(String subject, String pattern) {
    return getSubstringsMatching(subject, pattern);
  }

  public static String[] getSubstringsMatching(String subject, String patternString) {
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(subject);

    return accumulateMatches(matcher);
  }

  private static String[] accumulateMatches(Matcher matcher) {
    ArrayList<String> matches = new ArrayList<String>();
    while(matcher.find()) { matches.add(matcher.group()); }

    return matches.toArray(new String[matches.size()]);
  }
}
