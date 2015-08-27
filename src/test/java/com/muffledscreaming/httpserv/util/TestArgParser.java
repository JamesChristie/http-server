package com.muffledscreaming.httpserv.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArgParser {
  @Test
  public void testVacantArg() {
    String[] args    = new String[]{};
    ArgParser parser = new ArgParser(args);

    assertFalse(parser.optionPresent("f"));
    assertEquals("", parser.getValueForOption("f"));
  }

  @Test
  public void testSingleArg() {
    String[] args    = new String[]{"-f"};
    ArgParser parser = new ArgParser(args);

    assertTrue(parser.optionPresent("f"));
    assertEquals("", parser.getValueForOption("f"));
  }

  @Test
  public void argWithValue() {
    String[] args    = new String[]{"-f", "zogm"};
    ArgParser parser = new ArgParser(args);

    assertTrue(parser.optionPresent("f"));
    assertEquals("zogm", parser.getValueForOption("f"));
  }
}
