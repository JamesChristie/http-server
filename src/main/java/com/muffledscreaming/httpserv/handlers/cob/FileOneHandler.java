package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.MethodNotAllowed;

public class FileOneHandler extends Handler {
  public FileOneHandler(Request request) {
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
    Response ok = new Ok();
    ok.setBody("file1 contents");
    return ok;
  }
}
