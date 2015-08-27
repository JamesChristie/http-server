package com.muffledscreaming.httpserv.handlers.cob;

import java.io.IOException;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.MethodNotAllowed;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;

import java.nio.file.Paths;
public class FileOneHandler extends Handler {
  public FileOneHandler(Request request) {
    super(request);
  }

  public Response perform() {
    if (request.isGet()) {
      System.out.println(Paths.get(getPath().toString(), request.getPath()));
      return getOkResponse();
    } else {
      return new MethodNotAllowed();
    }
  }

  private Response getOkResponse() {
    try {
      Response ok = new Ok();
      ok.setBody(getFileContents());
      return ok;
    } catch (IOException readError) {
      return new InternalServerError();
    }
  }
}
