package com.muffledscreaming.httpserv.http.extractors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPath {
  @Test
  public void testEmptyRequest() {
    String requestString = "";
    assertEquals("", new Path(requestString).extract());
  }

  @Test
  public void testSimpleRequest() {
    String requestString = "GET / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n";
    assertEquals("/", new Path(requestString).extract());
  }

  @Test
  public void testRequestWithGetParams() {
    String requestString = "GET /some/path?somevar=someval HTTP/1.1\r\n"
                         + "Host: subdomain.otherthing.biz\r\n";
    assertEquals("/some/path", new Path(requestString).extract());
  }

  @Test
  public void testRequestWithNumbers() {
    String requestString = "GET /path123thing HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n";
    assertEquals("/path123thing", new Path(requestString).extract());
  }
}
