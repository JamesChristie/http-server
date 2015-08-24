package com.muffledscreaming.httpserv.handlers.cob;

import com.muffledscreaming.httpserv.server.Router;

public class Routes {
  public static void buildRoutes() {
    Router.register("/",                    "GET",     RootHandler.class);
    Router.register("/logs",                "GET",     LogsHandler.class);
    Router.register("/foobar",              "GET",     FoobarHandler.class);
    Router.register("/file1",               "GET",     FileOneHandler.class);
    Router.register("/file1",               "PUT",     FileOneHandler.class);
    Router.register("/text-file.txt",       "POST",    FileOneHandler.class);
    Router.register("/image.gif",           "GET",     ImageHandler.class);
    Router.register("/image.jpeg",          "GET",     ImageHandler.class);
    Router.register("/image.png",           "GET",     ImageHandler.class);
    Router.register("/partial_content.txt", "GET",     PartialHandler.class);
    Router.register("/form",                "GET",     FormHandler.class);
    Router.register("/form",                "POST",    FormHandler.class);
    Router.register("/form",                "PUT",     FormHandler.class);
    Router.register("/form",                "DELETE",  FormHandler.class);
    Router.register("/method_options",      "OPTIONS", OptionsHandler.class);
    Router.register("/redirect",            "GET",     RedirectHandler.class);
    Router.register("/parameters",          "GET",     ParametersHandler.class);
    Router.register("/patch-content.txt",   "GET",     PatchHandler.class);
    Router.register("/patch-content.txt",   "PATCH",   PatchHandler.class);
  }
}
