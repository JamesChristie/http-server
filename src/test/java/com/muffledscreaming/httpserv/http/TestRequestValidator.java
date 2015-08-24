package com.muffledscreaming.httpserv.http;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class TestRequestValidator {
  private class ValidRequest extends Request {
    public ValidRequest() { super(null, null, null); }

    public String getMethod() {
      return "GET";
    }

    public String getPath() {
      return "/some/path";
    }

    public String getVersion() {
      return "1.1";
    }

    public Set getFields() {
      Set fields = new HashSet<String>();
      fields.add("host");
      return fields;
    }

    public String getFieldValue(String field) {
      if (field.toLowerCase().equals("host")) { return "www.host.com"; }
      return "";
    }

    public String getBody() {
      return "";
    }
  }

  @Test
  public void testIsValidForValid() {
    Request valid = new ValidRequest();
    assertTrue(new RequestValidator(valid).isValid());
  }

  private class InvalidRequest extends Request {
    public InvalidRequest() { super(null, null, null); }

    public String getMethod() {
      return "";
    }

    public String getPath() {
      return "/some/path";
    }

    public String getVersion() {
      return "1.1";
    }

    public Set getFields() {
      return new HashSet<String>();
    }

    public String getFieldValue(String field) {
      return "";
    }

    public String getBody() {
      return "";
    }
  }

  @Test
  public void testIsValidForInvalid() {
    Request invalid = new InvalidRequest();
    assertFalse(new RequestValidator(invalid).isValid());
  }
}
