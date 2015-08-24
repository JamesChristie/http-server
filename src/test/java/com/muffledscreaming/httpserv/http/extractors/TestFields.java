package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFields {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Fields(requestString).extract());
  }

  @Test
  public void testSimpleRequest() {
    String requestString  = "GET / HTTP/1.1\r\n"
                          + "Host: www.host.com\r\n\r\n";
    String expectedFields = "Host: www.host.com";
    assertEquals(expectedFields, new Fields(requestString).extract());
  }

  @Test
  public void testRequestWithfields() {
    String requestString  = "GET / HTTP/1.1\r\n"
                          + "Host: www.host.com\r\n"
                          + "UserAgent: Awesomesauce/7.2\r\n\r\n";
    String expectedFields = "Host: www.host.com\r\nUserAgent: Awesomesauce/7.2";
    assertEquals(expectedFields, new Fields(requestString).extract());
  }

  @Test
  public void testRequestWithFieldsAndBody() {
    String requestString  = "PUT / HTTP/1.1\r\n"
                          + "Host: www.host.com\r\n"
                          + "UserAgent: Awesomesauce/7.2\r\n"
                          + "\r\n"
                          + "somevar=someval\r\n\r\n";
    String expectedFields = "Host: www.host.com\r\nUserAgent: Awesomesauce/7.2";
    assertEquals(expectedFields, new Fields(requestString).extract());
  }

  @Test
  public void testPatchRequestRegression() {
    String requestString  = "PATCH /patch-content.txt HTTP/1.1\r\n" +
                            "If-Match: dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec\r\n" +
                            "Content-Length: 15\r\n" +
                            "Host: localhost:5000\r\n" +
                            "Connection: Keep-Alive\r\n" +
                            "User-Agent: Apache-HttpClient/4.3.5 (java 1.5)\r\n" +
                            "Accept-Encoding: gzip,deflate\r\n" +
                            "\r\n" +
                            "patched content";

    String expectedFields = "If-Match: dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec\r\n" +
                            "Content-Length: 15\r\n" +
                            "Host: localhost:5000\r\n" +
                            "Connection: Keep-Alive\r\n" +
                            "User-Agent: Apache-HttpClient/4.3.5 (java 1.5)\r\n" +
                            "Accept-Encoding: gzip,deflate";

    assertEquals(expectedFields, new Fields(requestString).extract());
  }
}
