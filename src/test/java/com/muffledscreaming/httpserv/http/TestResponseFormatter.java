package com.muffledscreaming.httpserv.http;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import java.util.HashMap;

public class TestResponseFormatter {
  public class MockResponse extends Response {
    public MockResponse() {
      super();
      headers.put("Content-Type",   "text/html");
      headers.put("Content-Length", "9001");
    }

    public String getStatusCode() {
      return "200";
    }

    public String getStatusMessage() {
      return "OK";
    }

    public String getBody() {
      return "<html>zogmwtfbbq</html>";
    }
  }

  @Test
  public void testFormattedString() {
    String expectedResponse = "HTTP/1.1 200 OK\r\n" +
                              "Content-Length: 9001\r\n" +
                              "Content-Type: text/html\r\n" +
                              "\r\n" +
                              "<html>zogmwtfbbq</html>";

    String actualResponse = new ResponseFormatter(new MockResponse()).perform();

    assertEquals(expectedResponse, actualResponse);
  }

  public class MockResponseWithoutHeaders extends Response {
    public MockResponseWithoutHeaders() {
      super();
    }

    public String getStatusCode() {
      return "200";
    }

    public String getStatusMessage() {
      return "OK";
    }

    public String getBody() {
      return "<html>zogmwtfbbq</html>";
    }
  }

  @Test
  public void testFormattedStringWithoutHeaders() {
    String expectedResponse = "HTTP/1.1 200 OK\r\n" +
                              "\r\n" +
                              "<html>zogmwtfbbq</html>";

    String actualResponse = new ResponseFormatter(new MockResponseWithoutHeaders()).perform();

    assertEquals(expectedResponse, actualResponse);
  }
}
