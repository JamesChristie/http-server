package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Redirect;

public class RedirectHandler extends Handler {
  public RedirectHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response redirect = new Redirect();
    redirect.setHeader("Location", "http://localhost:5000/");
    return redirect;
  }
}
