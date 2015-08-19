package com.muffledscreaming.httpserv.mock;

import java.net.Socket;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class Mocket extends Socket {
  private String hostName;
  private int port;
  private String input;
  private OutputStream output;

  public Mocket(String hostName, int port) {
    this.hostName = hostName;
    this.port     = port;
  }

  public Mocket(String hostName, int port, String input) {
    this(hostName, port);
    this.input = input;
  }

  public Mocket(String hostName, int port, OutputStream output) {
    this(hostName, port);
    this.output = output;
  }

  public InputStream getInputStream() {
    return new ByteArrayInputStream(
      input.getBytes(StandardCharsets.UTF_8)
    );
  }

  public OutputStream getOutputStream() {
    if (output == null) {
      return new ByteArrayOutputStream();
    } else {
      return output;
    }
  }

  public void close() {
    // No-Op
  }
}
