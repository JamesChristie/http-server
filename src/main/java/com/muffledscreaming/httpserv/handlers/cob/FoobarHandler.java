package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.NotFound;

public class FoobarHandler extends Handler {
  public FoobarHandler(Request request) {
    super(request);
  }

  public Response perform() {
    return new NotFound();
  }
}
