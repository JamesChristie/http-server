package com.muffledscreaming.httpserv.handlers.cob;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Base64;
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
      response.setBody(getFileContents());
      return response;
    } catch (IOException readError) {
      return new InternalServerError();
    }
  }

  private String getFileContents(String fileName) throws IOException {
    Path path = Paths.get(getPath().toString(), request.getPath());
    byte[] fileBytes = Files.readAllBytes(path);
    return Base64.getEncoder().encodeToString(fileBytes);
  }
}
