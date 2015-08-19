package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.io.IOException;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.RequestFactory;
import com.muffledscreaming.httpserv.http.RequestValidator;
import com.muffledscreaming.httpserv.exception.ReadException;
import com.muffledscreaming.httpserv.exception.InvalidRequest;

public class ReadCommand {
  private Socket socket;

  public ReadCommand(Socket socket) {
    this.socket = socket;
  }

  public Request perform() throws InvalidRequest, ReadException {
    Request request = getRequest();

    if (new RequestValidator(request).isValid()) {
      return request;
    } else {
      throw new InvalidRequest("Received an invalid request", request);
    }
  }

  private Request getRequest() throws ReadException {
    try {
      String rawRequest = new SocketExtractor(socket).perform();
      return new RequestFactory(rawRequest).generate();
    } catch (IOException readError) {
      throw new ReadException("A read error has occured", readError);
    }
  }
}
