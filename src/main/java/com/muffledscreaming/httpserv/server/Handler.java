package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

import com.muffledscreaming.httpserv.server.RunnableServer;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;

public abstract class Handler {
  protected Request request;

  public Handler(Request request) {
    this.request = request;
  }

  public abstract Response perform();

  protected Path getPath() {
    return RunnableServer.getInstance().getPublicPath();
  }

  protected String getFileContents() throws IOException {
    Path path = Paths.get(getPath().toString(), request.getPath());
    byte[] fileBytes = Files.readAllBytes(path);
    return new String(fileBytes);
  }
}
