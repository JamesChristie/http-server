package com.muffledscreaming.httpserv.http;

import java.util.HashMap;

import com.muffledscreaming.httpserv.http.extractors.Method;
import com.muffledscreaming.httpserv.http.extractors.Path;
import com.muffledscreaming.httpserv.http.extractors.Version;
import com.muffledscreaming.httpserv.http.extractors.Port;
import com.muffledscreaming.httpserv.http.extractors.Body;
import com.muffledscreaming.httpserv.http.extractors.Fields;
import com.muffledscreaming.httpserv.http.extractors.Params;

import com.muffledscreaming.httpserv.http.Marshaller;

public class RequestFactory {
  private String requestString;

  public RequestFactory(String requestString) {
    this.requestString = requestString;
  }

  public Request generate() {
    return new Request(
      getComprehension(), getFields(), getParams()
    );
  }

  public HashMap getComprehension() {
    return new HashMap<String,String>() {{
      put(Request.METHOD_KEY,  new Method(requestString).extract());
      put(Request.PATH_KEY,    new Path(requestString).extract());
      put(Request.VERSION_KEY, new Version(requestString).extract());
      put(Request.PORT_KEY,    new Port(requestString).extract());
      put(Request.BODY_KEY,    new Body(requestString).extract());
    }};
  }

  public HashMap getFields() {
    String fieldsString = new Fields(requestString).extract();

    return new Marshaller(
      fieldsString, Fields.FIELD_DELIMITER, Marshaller.FIELD_ASSIGNMENT
    ).marshall();
  }

  public HashMap getParams() {
    String paramsString = new Params(requestString).extract();

    return new Marshaller(
      paramsString, Params.PARAM_DELIMITER, Marshaller.PARAM_ASSIGNMENT
    ).marshall();
  }
}
