package com.muffledscreaming.httpserv.http.marshallers;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TestFields {
  @Test
  public void testEmptyFields() {
    String rawFields = "";

    HashMap expectedFields = new HashMap<String,String>() {{}};
    HashMap actualFields   = new Fields(rawFields).marshall();

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void testPresentFields() {
    String rawFields = "some-field: thingy\r\nother-field: wat";

    HashMap expectedFields = new HashMap<String,String>() {{
      put("some-field",  "thingy");
      put("other-field", "wat");
    }};

    HashMap actualFields   = new Fields(rawFields).marshall();

    assertEquals(expectedFields, actualFields);
  }
}
