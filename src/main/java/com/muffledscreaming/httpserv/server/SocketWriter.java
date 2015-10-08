package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import com.muffledscreaming.httpserv.http.Response;

public class SocketWriter {
  private Socket socket;
  private OutputStream output;

  public SocketWriter(Socket socket) throws IOException {
    this.socket = socket;
    this.output = socket.getOutputStream();
  }

  public void dispatchResponse(InputStream response) throws IOException {
    int blockSize     = 8192;
    byte[] readBuffer = new byte[blockSize];

    int numBytesRead = response.read(readBuffer, 0, blockSize);
    while (numBytesRead != -1) {
      output.write(readBuffer, 0, numBytesRead);
      numBytesRead = response.read(readBuffer, 0, blockSize);
    }

    output.close();
  }
}
