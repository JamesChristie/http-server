package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.NotAuthorized;

public class LogsHandler extends Handler {
  public LogsHandler(Request request) {
    super(request);
  }

  public Response perform() {
    if (authIsValid()) {
      return getAuthorizedResponse();
    } else {
      return new NotAuthorized();
    }
  }

  private boolean authIsValid() {
    String auth = request.getFieldValue("Authorization");
    return auth.equals("Basic YWRtaW46aHVudGVyMg==");
  }

  private Response getAuthorizedResponse() {
    Response ok = new Ok();
    ok.setBody(
      "GET /log HTTP/1.1\r\n" +
      "PUT /these HTTP/1.1\r\n" +
      "HEAD /requests HTTP/1.1"
    );
    return ok;
  }
}
