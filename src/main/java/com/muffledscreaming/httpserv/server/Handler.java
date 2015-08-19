package com.muffledscreaming.httpserv.server;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;

public interface Handler {
  public Response respondTo(Request request);
}
