package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestParams {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Params(requestString).extract());
  }
  
  @Test
  public void testGetParams() {
    String requestString  = "GET /path.php?somevar=someval&othervar=otherval HTTP/1.1\r\n"
                          + "Host: subdomain.otherthing.biz\r\n";
    String expectedParams = "somevar=someval&othervar=otherval";
    assertEquals(expectedParams, new Params(requestString).extract());
  }

  @Test
  public void testBodyParams() {
    String requestString = "GET / HTTP/1.1\r\n"
                         + "Host: www.host.com:3333\r\n"
                         + "\r\n"
                         + "somevar=someval&othervar=otherval";
    String expectedParams = "somevar=someval&othervar=otherval";
    assertEquals(expectedParams, new Params(requestString).extract());
  }

  @Test
  public void testBothParams() {
    String requestString = "GET /path.php?somevar=someval HTTP/1.1\r\n"
                         + "Host: subdomain.otherthing.biz\r\n"
                         + "\r\n"
                         + "othervar=otherval";
    String expectedParams = "somevar=someval&othervar=otherval";
    assertEquals(expectedParams, new Params(requestString).extract());
  }

  @Test
  public void testBodyWithoutParams() {
    String requestString  = "PATCH /patch-content.txt HTTP/1.1\r\n" +
                            "If-Match: dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec\r\n" +
                            "Content-Length: 15\r\n" +
                            "Host: localhost:5000\r\n" +
                            "Connection: Keep-Alive\r\n" +
                            "User-Agent: Apache-HttpClient/4.3.5 (java 1.5)\r\n" +
                            "Accept-Encoding: gzip,deflate\r\n" +
                            "\r\n" +
                            "patched content";
    String expectedParams = "";
    assertEquals(expectedParams, new Params(requestString).extract());
  }
}
