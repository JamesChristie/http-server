package com.muffledscreaming.httpserv.mock;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.server.Handler;

public class MockHandler extends Handler {
  public MockHandler(Request request) {
    super(request);
  }

  public Response perform() {
    return new Ok();
  }
}
