package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBody {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Body(requestString).extract());
  }

  @Test
  public void testSimpleRequest() {
    String requestString  = "GET / HTTP/1.1\r\n"
                          + "Host: www.host.com\r\n\r\n";
    String expectedBody  = "";
    assertEquals(expectedBody, new Body(requestString).extract());
  }

  @Test
  public void testRequestWithBody() {
    String requestString = "PUT / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n"
                         + "UserAgent: Awesomesauce/7.2\r\n"
                         + "\r\n"
                         + "somevar=someval";
    String expectedBody  = "somevar=someval";
    assertEquals(expectedBody, new Body(requestString).extract());
  }
}
