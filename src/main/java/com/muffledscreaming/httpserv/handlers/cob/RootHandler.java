package com.muffledscreaming.httpserv.handlers.cob;

import java.nio.file.Files;
import java.io.IOException;
import java.lang.NullPointerException;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;

public class RootHandler extends Handler {
  public RootHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response response = new Ok();

    try {
      addFiles(response);
      return response;
    } catch (IOException | NullPointerException readError) {
      return new InternalServerError();
    }
  }

  private void addFiles(Response response) throws IOException {
    Files.walk(getPath()).forEach(filePath -> {
      String fileName = filePath.getFileName().toString();
      response.setBody(response.getBody() + generateLink(fileName));
    });
  }

  private String generateLink(String fileName) {
    return "<a href=\"/" + fileName + "\">" + fileName + "</a>";
  }
}
