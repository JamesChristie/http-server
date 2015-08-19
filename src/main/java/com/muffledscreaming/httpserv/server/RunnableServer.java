package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class RunnableServer implements Runnable {
  private int port;
  private ServerSocket socket;

  public RunnableServer(int port) {
    this.port = port;
    createSocket();
  }

  public void run() {
    while (!socket.isClosed()) {
      try { runWorker(); }
      catch (IOException socketError) {
        throw new RuntimeException("Could not read socket", socketError);
      }
    }
  }

  private void listen() {
  }

  public synchronized void stop() {
    try {
      socket.close();
    } catch (IOException socketError) {
      throw new RuntimeException("Could not close socket");
    }
  }

  private void createSocket() {
    try {
      this.socket = new ServerSocket(port);
    } catch (IOException socketError) {
      throw new RuntimeException("Could not open socket", socketError);
    }
  }

  private void runWorker() throws IOException {
    Socket clientSocket = socket.accept();
    new Thread(
      new Worker(clientSocket, new CobHandler())
    ).start();
  }
}
