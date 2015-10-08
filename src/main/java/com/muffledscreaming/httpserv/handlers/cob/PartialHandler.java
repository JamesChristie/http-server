package com.muffledscreaming.httpserv.handlers.cob;

import java.util.Arrays;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.PartialContent;
import com.muffledscreaming.httpserv.http.responses.InternalServerError;

public class PartialHandler extends Handler {
  private static final String CONTENT = "This is a file that contains text to read " +
                                        "part of in order to fulfill a 206.";

  public PartialHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response response = new PartialContent();

    try {
      setBody(response);
    } catch (IOException readError) {
      response = new InternalServerError();
    }

    return response;
  }

  private void setBody(Response response) throws IOException {
    byte[] partialBytes = new byte[]{};
    byte[] contents = getFileContents();

    if (getRangeParam().equals("bytes=0-4")) {
      partialBytes = Arrays.copyOfRange(contents, 0, 5);
    } else if (getRangeParam().equals("bytes=-6")) {
      partialBytes = Arrays.copyOfRange(contents, contents.length - 6, contents.length);
    } else if (getRangeParam().equals("bytes=4-")) {
      partialBytes = Arrays.copyOfRange(contents, 4, contents.length);
    }

    response.setBody(new ByteArrayInputStream(partialBytes));
  }

  private String getRangeParam() {
    return request.getFieldValue("Range");
  }
}
