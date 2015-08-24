package com.muffledscreaming.httpserv.server;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;

public abstract class Responder {
  private Request request;

  public Responder(Request request) {
    this.request = request;
  }

  public abstract Response perform();
}
