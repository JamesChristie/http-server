package com.muffledscreaming.httpserv.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.InstantiationException;
import java.lang.NoSuchMethodException;
import java.lang.IllegalAccessException;

import com.muffledscreaming.httpserv.http.Request;

public class Route {
  private Class handlerClass;

  public Route(Class handlerClass) {
    this.handlerClass = handlerClass;
  }

  public Handler getHandler(Request request) {
    try {
      return getInstance(request);
    } catch (InstantiationException instError) {
      throw new RuntimeException("Could not instatiate handler", instError);
    } catch (NoSuchMethodException methodError) {
      throw new RuntimeException("Method not implemented on handler", methodError);
    } catch (IllegalAccessException accessError) {
      throw new RuntimeException("Could not access handler method", accessError);
    } catch (InvocationTargetException invocationError) {
      throw new RuntimeException("Could not invoke handler method", invocationError);
    }
  }

  private Handler getInstance(Request request)
    throws InstantiationException,
           NoSuchMethodException,
           IllegalAccessException,
           InvocationTargetException
  {
    Constructor constructor = handlerClass.getConstructor(Request.class);
    return (Handler)constructor.newInstance(request);
  }
}
