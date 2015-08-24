package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.PartialContent;

public class PartialHandler extends Handler {
  private static final String CONTENT = "This is a file that contains text to read " +
                                        "part of in order to fulfill a 206.";

  public PartialHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response partial = new PartialContent();
    setBody(partial);
    return partial;
  }

  private void setBody(Response response) {
    if (getRange() == "bytes=0-4") {
      String substring = CONTENT.substring(0, 3);
      response.setBody(substring);
    } else if (getRange().equals("bytes=-6")) {
      String substring = CONTENT.substring(70, 75);
      response.setBody(substring);
    } else if (getRange().equals("bytes=4-")) {
      String substring = CONTENT.substring(3, 75);
      response.setBody(substring);
    }
  }

  private String getRange() {
    return request.getFieldValue("Range");
  }
}
