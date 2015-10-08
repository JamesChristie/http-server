package com.muffledscreaming.httpserv.server;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.Socket;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.muffledscreaming.httpserv.mock.Mocket;

public class TestSocketWriter {
  @Test
  public void testWrittenText() throws IOException {
    OutputStream output = new ByteArrayOutputStream();

    Socket mocket = new Mocket("localhost", 80, output);
    InputStream response = new ByteArrayInputStream(
      "test_text".getBytes(StandardCharsets.UTF_8)
    );

    new SocketWriter(mocket).dispatchResponse(response);

    assertEquals("test_text", output.toString());
  }
}
