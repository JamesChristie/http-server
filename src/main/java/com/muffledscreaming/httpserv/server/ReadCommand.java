package com.muffledscreaming.httpserv.server;

import java.net.Socket;

import com.muffledscreaming.httpserv.http.Request;

public class ReadCommand {
  private Socket socket;

  public ReadCommand(Socket socket) {
    this.socket = socket;
  }

  public Request perform() {
    return null;
  }
}
