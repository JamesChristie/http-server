package com.muffledscreaming.httpserv.server;

import org.junit.Test;
import static org.junit.Assert.*;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.mock.MockHandler;

public class TestRoute {
  @Test
  public void testGetHandler() {
    Route route     = new Route(MockHandler.class);
    Handler handler = route.getHandler(new Request(null, null, null));
    assertTrue(handler instanceof MockHandler);
  }
}
