package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.net.ServerSocket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import com.muffledscreaming.httpserv.server.ServerSettings;

public class RunnableServer implements Runnable {
  private ServerSettings settings;
  private ServerSocket socket;
  private boolean shutDown;

  private static RunnableServer instance;

  public static RunnableServer getInstance() {
    return instance;
  }

  public static RunnableServer getInstance(ServerSettings settings) {
    if (instance == null) {
      instance = new RunnableServer(settings);
    }

    return instance;
  }

  private RunnableServer(ServerSettings settings) {
    this.settings = settings;
    this.shutDown = false;
    createSocket();
  }

  public int getPort() {
    return settings.getPort();
  }

  public Path getPublicPath() {
    return Paths.get(settings.getPublicPath());
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
      this.socket = new ServerSocket(settings.getPort());
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
