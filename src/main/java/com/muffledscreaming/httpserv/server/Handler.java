package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.util.HashMap;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;

public abstract class Handler {
  protected Request request;

  public Handler(Request request) {
    this.request = request;
  }

  public abstract Response perform();
}
