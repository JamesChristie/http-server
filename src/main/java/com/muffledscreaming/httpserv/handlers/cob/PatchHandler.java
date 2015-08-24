package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.util.DataStore;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;
import com.muffledscreaming.httpserv.http.responses.NoContent;

public class PatchHandler extends Handler {
  private static final String KEY = "cob-patch-handler-data";

  private static final String DEFAULT_CONTENT = "default content";
  private static final String PATCHED_CONTENT = "patched content";

  private static final String CHANGE_MATCH = "dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec";
  private static final String REVERT_MATCH = "5c36acad75b78b82be6d9cbbd6143ab7e0cc04b0";

  public PatchHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response response = getResponse();
    mutateData();
    response.setBody(getData());
    return response;
  }

  private Response getResponse() {
    if (request.isPatch()) { return new NoContent(); }
    else { return new Ok(); }
  }

  private void mutateData() {
    if (dataShouldChange()) { setData(PATCHED_CONTENT); }
    else if (dataShouldRevert()) { setData(DEFAULT_CONTENT); }
  }

  private String getMatch() {
    return request.getFieldValue("If-Match");
  }

  private String getData() {
    String data = (String)DataStore.getValue(KEY);

    if (data == null || data.isEmpty()) { return DEFAULT_CONTENT; }
    else { return data; }
  }

  private void setData(String value) {
    DataStore.setValue(KEY, value);
  }

  private boolean dataShouldChange() {
    return request.isPatch() && getMatch().equals(CHANGE_MATCH);
  }

  private boolean dataShouldRevert() {
    return request.isPatch() && getMatch().equals(REVERT_MATCH);
  }
}
