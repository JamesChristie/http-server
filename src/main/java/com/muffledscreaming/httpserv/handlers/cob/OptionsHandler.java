package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;

public class OptionsHandler extends Handler {
  public OptionsHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response ok = new Ok();
    ok.setHeader("Allow", "GET,HEAD,POST,OPTIONS,PUT");
    return ok;
  }
}
