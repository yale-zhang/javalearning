package org.junit;

public interface Controller {
   Response processRequest(Request request) throws Exception;

   void addHandler(Request request,RequestHandler requestHandler);
}
