package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;

public class ParametersHandler extends Handler {
  public ParametersHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response ok = new Ok();
    ok.setBody(
      "variable_1 = Operators <, >, =, !=; +, -, " +
      "*, &, @, #, $, [, ]: \"is that all\"?" +
      "variable_2 = stuff"
    );
    return ok;
  }
}
