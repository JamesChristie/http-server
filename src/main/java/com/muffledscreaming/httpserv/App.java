package com.muffledscreaming.httpserv;

import com.muffledscreaming.httpserv.server.RunnableServer;

public class App {
  public static final int DEFAULT_PORT = 8080;

  public static void main(String[] args) {
    System.out.println("Creatng server");
    RunnableServer server = new RunnableServer(DEFAULT_PORT);

    System.out.println("Starting server");
    new Thread(server).start();

    System.out.println("Stopping server");
    server.stop();
  }
}
