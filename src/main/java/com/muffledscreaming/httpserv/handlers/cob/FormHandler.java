package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Handler;
import com.muffledscreaming.httpserv.util.DataStore;
import com.muffledscreaming.httpserv.http.Strings;
import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;

public class FormHandler extends Handler {
  private static final String KEY = "cob-form-handler-data";

  public FormHandler(Request request) {
    super(request);
  }

  public Response perform() {
    Response ok = new Ok();
    mutateData();
    addData(ok);
    return ok;
  }

  private void mutateData() {
    if (request.isPost()) {
      DataStore.setValue(KEY, "fatcat");
    } else if (request.isPut()) {
      DataStore.setValue(KEY, "heathcliff");
    } else if (request.isDelete()) {
      DataStore.setValue(KEY, "");
    }
  }

  private void addData(Response response) {
    String value = getData();

    if (value != null && !value.isEmpty()) {
      response.setBody("data=" + value);
    }
  }

  private String getData() {
    return (String)DataStore.getValue(KEY);
  }
}
