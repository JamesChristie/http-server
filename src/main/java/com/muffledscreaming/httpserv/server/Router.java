package com.muffledscreaming.httpserv.server;

import java.util.HashMap;

import com.muffledscreaming.httpserv.http.Request;
import com.muffledscreaming.httpserv.http.Response;
import com.muffledscreaming.httpserv.exception.RoutingError;

public class Router {
  private static final String DELIMITER = "#";

  private static HashMap<String,Route> routeMap;

  public static void register(String path, String method, Class handlerClass) {
    ensureRouteMap();

    String routeKey = getRouteKey(path, method);
    Route route     = new Route(handlerClass);

    routeMap.put(routeKey, route);
  }

  public static Response dispatch(Request request) throws RoutingError {
    ensureRouteMap();

    String routeKey = getRouteKey(request.getPath(), request.getMethod());
    Handler handler = getRoute(routeKey).getHandler(request);

    return handler.perform();
  }

  public static void reset() {
    routeMap = new HashMap<String,Route>();
  }

  private static void ensureRouteMap() {
    if (routeMap == null) { reset(); }
  }

  private static String getRouteKey(String path, String method) {
    return path + DELIMITER + method;
  }

  private static Route getRoute(String routeKey) throws RoutingError {
    Route route = routeMap.get(routeKey);

    if (route == null) {
      throw new RoutingError("Could not locate route", routeKey);
    }

    return route;
  }
}
