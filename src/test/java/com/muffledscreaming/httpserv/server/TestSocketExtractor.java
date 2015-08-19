package com.muffledscreaming.httpserv.server;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.Socket;
import java.io.IOException;

import com.muffledscreaming.httpserv.mock.Mocket;

public class TestSocketExtractor {
  @Test
  public void testSocketExtraction() {
    Socket mocket          = new Mocket("localhost", 80, "test");
    String extractedString = "";

    try {
      extractedString = new SocketExtractor(mocket).perform();
    } catch (IOException readError) {
      System.err.println(readError.getMessage());
    }

    assertEquals("test", extractedString);
  }
}
