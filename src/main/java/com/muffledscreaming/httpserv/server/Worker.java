package com.muffledscreaming.httpserv.server;

import java.net.Socket;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.ResponseFormatter;
import com.muffledscreaming.httpserv.http.responses.BadRequest;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;
import com.muffledscreaming.httpserv.http.responses.NotFound;
import com.muffledscreaming.httpserv.exception.HttpservException;
import com.muffledscreaming.httpserv.exception.InvalidRequest;
import com.muffledscreaming.httpserv.exception.RoutingError;
import com.muffledscreaming.httpserv.exception.WriteException;

public class Worker implements Runnable {
  private Socket clientSocket;

  public Worker(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  public void run() {
    try { handleRequest(); }
    catch (WriteException writeError) {
      throw new RuntimeException("Could not write to socket", writeError);
    }
  }

  private void handleRequest() throws WriteException {
    try {
      Request request   = new ReadCommand(clientSocket).perform();
      Response response = Router.dispatch(request);
      new WriteCommand(clientSocket, response).perform();
    } catch (RoutingError routeError) {
      new WriteCommand(clientSocket, new NotFound()).perform();
    } catch (InvalidRequest err) {
      new WriteCommand(clientSocket, new BadRequest()).perform();
    } catch (HttpservException err) {
      new WriteCommand(clientSocket, new InternalServerError()).perform();
    }
  }
}
