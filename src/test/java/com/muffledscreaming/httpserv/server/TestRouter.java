package com.muffledscreaming.httpserv.server;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import com.muffledscreaming.httpserv.mock.MockHandler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.exception.RoutingError;

public class TestRouter extends TestCase {
  private class MockRequest extends Request {
    public MockRequest() { super(null, null, null); }
    public String getMethod() { return "GET"; }
    public String getPath() { return "/path"; }
  }

  public void setUp() {
    Router.reset();
  }

  @Test
  public void testNonExistantRouteAssignment() throws RoutingError {
    try {
      Request request = new MockRequest();
      Response response = Router.dispatch(request);
    } catch (RoutingError error) {
      assertTrue(error instanceof RoutingError);
    }
  }

  @Test
  public void testRouteAssignment() throws RoutingError {
    Router.register("/path", "GET", MockHandler.class);

    Request request = new MockRequest();
    Response response = Router.dispatch(request);

    assertTrue(response instanceof Ok);
  }
}
