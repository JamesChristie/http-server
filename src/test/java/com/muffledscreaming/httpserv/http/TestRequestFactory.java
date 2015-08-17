package com.muffledscreaming.httpserv.http;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class TestRequestFactory {
  private String requestString;
  private RequestFactory factory;

  public void setUp() {
    this.requestString = "PUT / HTTP/1.1\r\n"
                       + "Host: www.host.com\r\n"
                       + "UserAgent: Awesomesauce/7.2\r\n"
                       + "\r\n"
                       + "somevar=someval";

    this.factory = new RequestFactory(requestString);
  }

  @Test
  public void testComprehensionOfBasicRequest() {
    HashMap expectedComprehension = new HashMap<String,String>() {{
    }};

    HashMap actualComprehension = factory.getComprehension();

    assertEquals(expectedComprehension, actualComprehension);
  }

  @Test
  public void testFieldsOfBasicRequest() {
    HashMap expectedFields = new HashMap<String,String>() {{
    }};

    HashMap actualFields = factory.getFields();

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void testParamsOfBasicRequest() {
    HashMap expectedParams = new HashMap<String,String>() {{
    }};

    HashMap actualParams = factory.getParams();

    assertEquals(expectedParams, actualParams);
  }
}
