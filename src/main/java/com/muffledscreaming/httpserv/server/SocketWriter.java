package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

import com.muffledscreaming.httpserv.http.Response;

public class SocketWriter {
  private Socket socket;
  private OutputStream output;
  private PrintWriter writer;

  public SocketWriter(Socket socket) throws IOException {
    this.socket = socket;
    this.output = socket.getOutputStream();
    this.writer = new PrintWriter(output, true);
  }

  public void dispatchResponse(String response) throws IOException {
    writer.print(response);
    writer.close();
    output.close();
  }
}
