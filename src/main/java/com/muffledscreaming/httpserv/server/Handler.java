package com.muffledscreaming.httpserv.server;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;

public abstract class Handler {
  protected Request request;

  public Handler() {}

  public Response perform(Request request) {
    this.request = request;
    return perform();
  }

  protected abstract Response perform();
}
