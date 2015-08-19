package com.muffledscreaming.httpserv.server;

import java.net.Socket;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.server.ReadCommand;
import com.muffledscreaming.httpserv.server.WriteCommand;
import com.muffledscreaming.httpserv.exception.HttpservException;

public class Worker implements Runnable {
  private Socket clientSocket;
  private Handler handler;

  public Worker(Socket clientSocket, Handler handler) {
    this.clientSocket = clientSocket;
    this.handler      = handler;
  }

  public void run() {
    try { handleRequest(); }
    catch (HttpservException readError) {}
  }

  private void handleRequest() throws HttpservException {
    Request request   = new ReadCommand(clientSocket).perform();
    Response response = handler.perform(request);
    new WriteCommand(clientSocket, response).perform();
  }
}
