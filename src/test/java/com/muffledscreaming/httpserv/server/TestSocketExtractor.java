package com.muffledscreaming.httpserv.server;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.Socket;
import java.io.IOException;

import com.muffledscreaming.httpserv.mock.Mocket;

public class TestSocketExtractor {
  @Test
  public void testSocketExtraction() {
    String requestString = "POST /some/path HTTP/1.1\r\n" +
                           "Host: localhost\r\n" +
                           "\r\n" +
                           "someVar=someVal\r\n";

    Socket mocket          = new Mocket("localhost", 80, requestString);
    String extractedString = "";

    try {
      extractedString = new SocketExtractor(mocket).perform();
    } catch (IOException readError) {
      System.err.println(readError.getMessage());
    }

    assertEquals(requestString, extractedString);
  }
}
