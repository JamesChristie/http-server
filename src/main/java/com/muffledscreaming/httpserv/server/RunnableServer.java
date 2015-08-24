package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class RunnableServer implements Runnable {
  private int port;
  private ServerSocket socket;
  private boolean shutDown;

  public RunnableServer(int port) {
    this.port     = port;
    this.shutDown = false;
    createSocket();
  }

  public void run() {
    while (!shutDown) {
      try { runWorker(); }
      catch (IOException socketError) {
        throw new RuntimeException("Could not read socket", socketError);
      }
    }
  }

  private void runWorker() throws IOException {
    Socket clientSocket = socket.accept();
    new Thread(
      new Worker(clientSocket)
    ).start();
  }

  public synchronized void stop() {
    this.shutDown = true;
  }

  private void createSocket() {
    try {
      this.socket = new ServerSocket(port);
    } catch (IOException socketError) {
      throw new RuntimeException("Could not open socket", socketError);
    }
  }

  private void closeSocket() {
    try {
      socket.close();
    } catch (IOException socketError) {
      throw new RuntimeException("Could not close socket");
    }
  }
}
