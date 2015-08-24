package com.muffledscreaming.httpserv.handlers.cob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;

public class ImageHandler extends Handler {
  public ImageHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response response = new Ok();

    try { response.setBody(getBodyContent()); }
    catch (IOException readError) {
      response = new InternalServerError();
    }

    return response;
  }

  private String getBodyContent() throws IOException {
    if (request.getPath().contains(".jpeg")) {
      return getFileContents("image.jpeg");
    } else if (request.getPath().contains(".gif")) {
      return getFileContents("image.gif");
    } else {
      return getFileContents("image.png");
    }
  }

  private String getFileContents(String fileName) throws IOException {
    Path path = FileSystems.getDefault().getPath("public", fileName);
    byte[] encoded = Files.readAllBytes(path);
    return new String(encoded);
  }
}
