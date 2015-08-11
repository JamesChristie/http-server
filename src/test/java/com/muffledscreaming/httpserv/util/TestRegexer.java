package com.muffledscreaming.httpserv.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRegexer {
  @Test
  public void testSimpleMatch() {
    String subject       = "xxxxxxx@xxxxxxxxx@xxxxxx";
    String patternString = "@";

    String[] expectedMatches = {"@", "@"};
    String[] actualMatches   = Regexer.getSubstringsMatching(
      subject, patternString
    );

    assertArrayEquals(expectedMatches, actualMatches);
  }
}
