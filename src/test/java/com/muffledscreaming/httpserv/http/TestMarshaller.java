package com.muffledscreaming.httpserv.http;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TestMarshaller {
  @Test
  public void testEmptyFields() {
    String rawFields = "";

    HashMap expectedFields = new HashMap<String,String>() {{}};
    HashMap actualFields   = new Marshaller(rawFields, "\r\n", ": ").marshall();

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void testPresentFields() {
    String rawFields = "some-field: thingy\r\nother-field: wat";

    HashMap expectedFields = new HashMap<String,String>() {{
      put("some-field",  "thingy");
      put("other-field", "wat");
    }};

    HashMap actualFields   = new Marshaller(rawFields, "\r\n", ": ").marshall();

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void testEmptyParams() {
    String rawParams = "";

    HashMap expectedParams = new HashMap<String,String>() {{}};
    HashMap actualParams   = new Marshaller(rawParams, "&", "=").marshall();

    assertEquals(expectedParams, actualParams);
  }

  @Test
  public void testPresentParams() {
    String rawParams = "someField=thingy&otherField=wat";

    HashMap expectedParams = new HashMap<String,String>() {{
      put("someField",  "thingy");
      put("otherField", "wat");
    }};

    HashMap actualParams   = new Marshaller(rawParams, "&", "=").marshall();

    assertEquals(expectedParams, actualParams);
  }
}
