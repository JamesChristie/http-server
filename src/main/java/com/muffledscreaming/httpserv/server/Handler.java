package com.muffledscreaming.httpserv.server;

import com.muffledscreaming.httpserv.http.Request;

public interface Handler {
  public Response respondTo(Request request);
}
