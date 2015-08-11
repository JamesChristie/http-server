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
                          + "UserAgent: Awesomesauce/7.2\r\n";
    String expectedFields = "Host: www.host.com\r\nUserAgent: Awesomesauce/7.2";
    assertEquals(expectedFields, new Fields(requestString).extract());
  }

  @Test
  public void testRequestWithFieldsAndBody() {
    String requestString  = "PUT / HTTP/1.1\r\n"
                          + "Host: www.host.com\r\n"
                          + "UserAgent: Awesomesauce/7.2\r\n"
                          + "\r\n"
                          + "somevar=someval";
    String expectedFields = "Host: www.host.com\r\nUserAgent: Awesomesauce/7.2";
    assertEquals(expectedFields, new Fields(requestString).extract());
  }
}
