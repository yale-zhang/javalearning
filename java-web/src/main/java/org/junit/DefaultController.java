package org.junit;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {

    private Map requestHandlers = new HashMap();

    protected RequestHandler getHandler(Request request){
        if (!this.requestHandlers.containsKey(request.getName())){
            throw new RuntimeException("Cannot find handler for request name"+"["+request.getName()+"]");
        }
        return (RequestHandler)this.requestHandlers.get(request.getName());
    }

    @Override
    public Response processRequest(Request request){
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception e) {
            response =  new ErrorResponse(request,e);
        }
        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlers.containsKey(request.getName())){
            throw new RuntimeException("a request hadler has already been registered for request name "+"["+request.getName()+"]");
        }else {
            this.requestHandlers.put(request.getName(),requestHandler);
        }
    }
}
