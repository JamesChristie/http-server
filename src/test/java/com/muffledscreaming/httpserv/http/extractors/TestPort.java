package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPort {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Port(requestString).extract());
  }

  @Test
  public void testSimpleRequest() {
    String requestString = "GET / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n";
    assertEquals("80", new Port(requestString).extract());
  }

  @Test
  public void testNonDefaultPort() {
    String requestString = "GET / HTTP/1.1\r\n"
                         + "Host: www.host.com:3333\r\n";
    assertEquals("3333", new Port(requestString).extract());
  }
}
