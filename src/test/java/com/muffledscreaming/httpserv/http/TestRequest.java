package com.muffledscreaming.httpserv.http;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class TestRequest extends TestCase {
  private HashMap comprehension;
  private HashMap fields;
  private HashMap params;

  private Request request;

  public void setUp() {
    this.comprehension = new HashMap<String,String>() {{
      put("method",  "PUT");
      put("path",    "/");
      put("version", "1.1");
      put("port",    "80");
      put("body",    "somevar=someval");
    }};

    this.fields = new HashMap<String,String>() {{
      put("Host", "www.host.com");
      put("UserAgent", "Awesomesauce/7.2");
    }};

    this.params = new HashMap<String,String>() {{
      put("somevar", "someval");
    }};

    this.request = new Request(comprehension, fields, params);
  }

  @Test
  public void testGetMethod() {
    assertEquals("PUT", request.getMethod());
  }

  @Test
  public void testGetPath() {
    assertEquals("/", request.getPath());
  }

  @Test
  public void testGetVersion() {
    assertEquals("1.1", request.getVersion());
  }

  @Test
  public void testGetPort() {
    assertEquals("80", request.getPort());
  }

  @Test
  public void testGetBody() {
    assertEquals("somevar=someval", request.getBody());
  }

  @Test
  public void testGetFields() {
    Set expectedFields = new HashSet<String>() {{
      add("Host"); add("UserAgent");
    }};

    assertEquals(expectedFields, request.getFields());
  }

  @Test
  public void testGetParams() {
    Set expectedParams = new HashSet<String>() {{ add("somevar"); }};

    assertEquals(expectedParams, request.getParams());
  }

  @Test
  public void testGetFieldValue() {
    assertEquals("www.host.com", request.getFieldValue("Host"));
  }

  @Test
  public void testGetParamValue() {
    assertEquals("someval", request.getParamValue("somevar"));
  }
}
