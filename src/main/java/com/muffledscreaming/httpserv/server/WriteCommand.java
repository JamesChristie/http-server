package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.io.InputStream;
import java.io.IOException;

import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.ResponseFormatter;
import com.muffledscreaming.httpserv.exception.WriteException;

public class WriteCommand {
  private Socket socket;
  private Response response;

  public WriteCommand(Socket socket, Response response) {
    this.socket   = socket;
    this.response = response;
  }

  public void perform() throws WriteException {
    try {
      InputStream responseStream = getResponseStream();
      new SocketWriter(socket).dispatchResponse(responseStream);
    } catch (IOException writeError) {
      throw new WriteException("A write error has occured", writeError);
    }
  }

  private InputStream getResponseStream() {
    return new ResponseFormatter(response).perform();
  }
}
