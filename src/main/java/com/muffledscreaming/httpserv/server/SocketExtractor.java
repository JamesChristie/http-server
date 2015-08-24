package com.muffledscreaming.httpserv.server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SocketExtractor {
  private Socket socket;

  public SocketExtractor(Socket socket) {
    this.socket          = socket;
  }

  public String perform() throws IOException {
    String nextLine;
    String rawRequest = "";
    BufferedReader input = getInputReader();

    while (input.ready() || rawRequest.length() == 0) {
      rawRequest += (char)input.read();
    }

    return rawRequest;
  }

  private BufferedReader getInputReader() throws IOException {
    InputStream stream = socket.getInputStream();
    Charset charset    = StandardCharsets.UTF_8;

    InputStreamReader streamReader = new InputStreamReader(stream, charset);

    return new BufferedReader(streamReader);
  }
}
