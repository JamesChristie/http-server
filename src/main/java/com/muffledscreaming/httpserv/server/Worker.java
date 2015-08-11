package com.muffledscreaming.httpserv.server;

import java.net.Socket;

public class Worker {
  private Socket clientSocket;

  public Worker(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  public void perform() {
    // read
    // handle
    // write
  }
}
