package com.muffledscreaming.httpserv.mock;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestMocket {
  private static final String hostName = "localhost";
  private static final int port        = 80;

  @Test
  public void testGetInputStream() throws IOException {
    Socket mocket = new Mocket(
      hostName, port, "Some text goes here!"
    );

    // Ensure what is returned can be treated like
    // normal socket output
    String output = "";
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(
        mocket.getInputStream(),
        StandardCharsets.UTF_8
      )
    );

    String readLine = "";
    while ((readLine = reader.readLine()) != null) {
      output += readLine;
    }

    assertEquals("Some text goes here!", output);
  }
}
