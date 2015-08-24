package com.muffledscreaming.httpserv.util;

import java.util.HashMap;

public class DataStore {
  private static final HashMap<String,Object> storage = new HashMap<String,Object>();

  public static void setValue(String key, Object value) {
    storage.put(key, value);
  }

  public static Object getValue(String key) {
    return storage.get(key);
  }
}
