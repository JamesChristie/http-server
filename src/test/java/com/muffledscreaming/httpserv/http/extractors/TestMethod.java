package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMethod {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Method(requestString).extract());
  }

  @Test
  public void testSimpleRequest() {
    String requestString = "GET / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n";
    assertEquals("GET", new Method(requestString).extract());
  }

  @Test
  public void testLowerCasePostRequest() {
    String requestString = "post / http/1.1\r\n"
                         + "host: www.host.com\r\n\r\n"
                         + "someVar=someVal";
    assertEquals("POST", new Method(requestString).extract());
  }
}
