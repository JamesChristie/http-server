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
}
