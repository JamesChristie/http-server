package com.muffledscreaming.httpserv.util;

import org.junit.Test;
import static org.junit.Assert.*;

import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.http.responses.Ok;

public class TestDataStore {
  @Test
  public void testStoreString() {
    DataStore.setValue("key", "value");
    assertEquals("value", (String)DataStore.getValue("key"));
  }

  @Test
  public void testStoreResponse() {
    Response ok = new Ok();
    DataStore.setValue("key", ok);
    Response exhumedOk = (Ok)DataStore.getValue("key");

    assertEquals("200", exhumedOk.getStatusCode());
  }
}
