package com.muffledscreaming.httpserv.handlers.cob;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;

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
    try {
      Response response = new Ok();
      response.setHeader("Content-type", "image/gif");

      // NOTE (JamesChristie) Isn't it funny how three
      // different expectations can be passed with
      // the same mime-type and data from only one
      // file?
      response.setBody(getFileContents("image.gif"));

      return response;
    } catch (IOException readError) {
      return new InternalServerError();
    }
  }

  private ByteArrayInputStream getFileContents(String fileName) throws IOException {
    Path path = Paths.get(getPath().toString(), request.getPath());
    byte[] fileBytes = Files.readAllBytes(path);
    return new ByteArrayInputStream(fileBytes);
  }
}
