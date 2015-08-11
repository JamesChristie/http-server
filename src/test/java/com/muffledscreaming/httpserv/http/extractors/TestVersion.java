package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestVersion {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Version(requestString).extract());
  }

  @Test
  public void testSimpleRequest() {
    String requestString = "GET / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n";
    assertEquals("1.1", new Version(requestString).extract());
  }

  @Test
  public void testSimpleRequestWithHttpTwo() {
    String requestString = "GET / HTTP/2.0\r\n"
                         + "Host: www.host.com:3333\r\n";
    assertEquals("2.0", new Version(requestString).extract());
  }

  @Test
  public void testHeadersWithPotentiallyConfusingParams() {
    String requestString = "GET /path.php?HTTP=HTTP/1.1 HTTP/1.1\r\n"
                         + "Host: subdomain.otherthing.biz\r\n";
    assertEquals("1.1", new Version(requestString).extract());
  }
}
