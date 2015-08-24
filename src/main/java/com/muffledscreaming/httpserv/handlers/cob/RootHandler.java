package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;

public class RootHandler extends Handler {
  public RootHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response ok = new Ok();
    ok.setBody(
      generateLink("file1") + "\n" +
      generateLink("file2") + "\n" +
      generateLink("image.gif") + "\n" +
      generateLink("image.jpeg") + "\n" +
      generateLink("image.png") + "\n" +
      generateLink("partial_content.txt") + "\n" +
      generateLink("patch-content.txt") + "\n" +
      generateLink("text-file.txt") + "\n"
    );
    return ok;
  }

  private String generateLink(String fileName) {
    return "<a href=\"/" + fileName + "\">" + fileName + "</a>";
  }
}
