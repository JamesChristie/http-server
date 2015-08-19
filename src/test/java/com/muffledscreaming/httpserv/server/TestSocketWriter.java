package com.muffledscreaming.httpserv.server;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.Socket;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.muffledscreaming.httpserv.mock.Mocket;

public class TestSocketWriter {
  @Test
  public void testWrittenText() throws IOException {
    OutputStream output = new ByteArrayOutputStream();

    Socket mocket   = new Mocket("localhost", 80, output);
    String response = "test_text";

    new SocketWriter(mocket).dispatchResponse(response);

    assertEquals(response, output.toString());
  }
}
