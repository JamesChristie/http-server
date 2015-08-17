package com.muffledscreaming.httpserv.http.marshallers;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TestParams {
  @Test
  public void testEmptyParams() {
    String rawParams = "";

    HashMap expectedParams = new HashMap<String,String>() {{}};
    HashMap actualParams   = new Params(rawParams).marshall();

    assertEquals(expectedParams, actualParams);
  }

  @Test
  public void testPresentParams() {
    String rawParams = "someField=thingy&otherField=wat";

    HashMap expectedParams = new HashMap<String,String>() {{
      put("someField",  "thingy");
      put("otherField", "wat");
    }};

    HashMap actualParams   = new Params(rawParams).marshall();

    assertEquals(expectedParams, actualParams);
  }
}
