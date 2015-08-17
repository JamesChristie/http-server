package com.muffledscreaming.httpserv.http;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TestRequestFactory {
  @Test
  public void testComprehensionOfBasicRequest() {
    String requestString = "PUT / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n"
                         + "UserAgent: Awesomesauce/7.2\r\n"
                         + "\r\n"
                         + "somevar=someval";

    HashMap expected = new HashMap<String,String>() {{
      put("method",  "PUT");
      put("path",    "/");
      put("version", "1.1");
      put("port",    "80");
      put("body",    "somevar=someval");
    }};

    HashMap actual = new RequestFactory(requestString).getComprehension();

    assertEquals(expected, actual);
  }

  @Test
  public void testFieldsOfBasicRequest() {
    String requestString = "PUT / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n"
                         + "UserAgent: Awesomesauce/7.2\r\n"
                         + "\r\n"
                         + "somevar=someval";

    HashMap expectedFields = new HashMap<String,String>() {{
      put("Host", "www.host.com");
      put("UserAgent", "Awesomesauce/7.2");
    }};

    HashMap actualFields = new RequestFactory(requestString).getFields();

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void testParamsOfBasicRequest() {
    String requestString = "PUT / HTTP/1.1\r\n"
                         + "Host: www.host.com\r\n"
                         + "UserAgent: Awesomesauce/7.2\r\n"
                         + "\r\n"
                         + "somevar=someval";

    HashMap expectedParams = new HashMap<String,String>() {{
      put("somevar", "someval");
    }};

    HashMap actualParams = new RequestFactory(requestString).getParams();

    assertEquals(expectedParams, actualParams);
  }
}
