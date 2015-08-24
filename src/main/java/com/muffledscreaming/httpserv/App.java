package com.muffledscreaming.httpserv;

import com.muffledscreaming.httpserv.server.Router;
import com.muffledscreaming.httpserv.server.RunnableServer;
import com.muffledscreaming.httpserv.handlers.cob.Routes;

public class App {
  public static final int DEFAULT_PORT = 5000;

  private boolean shutDown = false;

  public static void main(String[] args) {
    System.out.print("Starting server, press Ctrl-C to halt...");
    Router.reset();
    RunnableServer server = new RunnableServer(DEFAULT_PORT);
    addShutdownHook(server);
    buildRoutes();
    new Thread(server).start();
    System.out.println("Done.");
  }

  private static void addShutdownHook(RunnableServer server) {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        System.out.println("SIGINT received, shutting down...");
        server.stop();
      }
    });
  }

  private static void buildRoutes() {
    Routes.buildRoutes();
  }
}
