package com.muffledscreaming.httpserv.server;

import java.net.Socket;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.ResponseFormatter;
import com.muffledscreaming.httpserv.http.responses.BadRequest;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;
import com.muffledscreaming.httpserv.exception.HttpservException;
import com.muffledscreaming.httpserv.exception.InvalidRequest;

public class Worker implements Runnable {
  private Socket clientSocket;

  public Worker(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  public void run() {
    try { handleRequest(); }
    catch (HttpservException readError) {}
  }

  private void handleRequest() throws HttpservException {
    try {
      Request request   = new ReadCommand(clientSocket).perform();
      Response response = Router.dispatch(request);
      new WriteCommand(clientSocket, response).perform();
    } catch (InvalidRequest err) {
      new WriteCommand(clientSocket, new BadRequest()).perform();
    } catch (HttpservException err) {
      new WriteCommand(clientSocket, new InternalServerError()).perform();
    }
  }
}
