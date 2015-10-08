package com.muffledscreaming.httpserv.handlers.cob;

import java.io.IOException;
import java.io.ByteArrayInputStream;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.MethodNotAllowed;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;

public class FileHandler extends Handler {
  public FileHandler(Request request) {
    super(request);
  }

  public Response perform() {
    if (request.isGet()) {
      return getOkResponse();
    } else {
      return new MethodNotAllowed();
    }
  }

  private Response getOkResponse() {
    try {
      Response ok = new Ok();
      ok.setBody(
        new ByteArrayInputStream(getFileContents())
      );
      return ok;
    } catch (IOException readError) {
      return new InternalServerError();
    }
  }
}
