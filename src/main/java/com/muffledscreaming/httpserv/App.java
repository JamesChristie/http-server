package com.muffledscreaming.httpserv;

import com.muffledscreaming.httpserv.util.ArgParser;
import com.muffledscreaming.httpserv.server.ServerSettings;
import com.muffledscreaming.httpserv.server.Router;
import com.muffledscreaming.httpserv.server.RunnableServer;
import com.muffledscreaming.httpserv.handlers.cob.Routes;

public class App {
  private boolean shutDown = false;

  public static void main(String[] args) {
    ArgParser parser        = new ArgParser(args);
    ServerSettings settings = new ServerSettings(parser);
    RunnableServer server   = RunnableServer.getInstance(settings);

    System.out.println(
      "Starting server, on port " + settings.getPort() +
      " with public path " + settings.getPublicPath() +
      " press Ctrl-C to halt..."
    );

    addShutdownHook(server);
    buildRoutes();
    new Thread(server).start();
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
    Router.reset();
    Routes.buildRoutes();
  }
}
