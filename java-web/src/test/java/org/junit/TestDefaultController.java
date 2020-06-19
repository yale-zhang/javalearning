package org.junit;

import static org.junit.Assert.*;

public class TestDefaultController {
    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    private class SampleRequest implements Request{
        private static final String DEFAULT_NAME ="Test";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }
        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        public String getName(){
            return this.name;
        }
    }

    private class SampleHandler implements RequestHandler{
        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response{
        private static final String NAME = "Test";
        public String getName(){
            return NAME;
        }
        public boolean equals(Object object){
            boolean result =false;
            if (object instanceof SampleResponse){
                result = ((SampleResponse) object).getName().equals(getName());
            }
            return result;
        }
        public int hashCode(){
            return NAME.hashCode();
        }
    }

    public class SampleExceptionHandler implements RequestHandler{
        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }


    @Before
    public void instantiate() throws Exception{
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();
    }

    @Test
    public void testMethod(){
        //throw new RuntimeException("implement me");
        controller.addHandler(request,handler);
        RequestHandler handler1 = controller.getHandler(request);
        assertSame("handler we set in controller should be the same handler we get",handler,handler1);
    }

    @Test
    public void testProcessRequest(){
        controller.addHandler(request,handler);
        Response response = controller.processRequest(request);
        assertNotNull("must not return a null response",response);
        //assertEquals("response should be of type sampleResponse",SampleResponse.class,response.getClass());
        assertEquals(new SampleResponse(),response);
    }
    @Test
    public void testProcessRequestAnswersErrorResponse(){
        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler(request,handler);
        Response response = controller.processRequest(request);
        assertNotNull("must not return a null response",response);
        assertEquals(ErrorResponse.class,response.getClass());

    }
    // 异常测试

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined(){
        SampleRequest request = new SampleRequest("testNotdefined");
        controller.getHandler(request);
    }
    @Test//(expected = RuntimeException.class)
    public void testAddRequestDuplicateName(){
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();
        controller.addHandler(request, handler);
    }

    //超时测试
    @Test(timeout = 10)
    @Ignore(value = "ignore for now until we decide a decent time-limit")
    public void testProcessMulipleRequestsTimeout(){
        Response response = new SampleResponse();
        for (int i=0;i<99999;i++){
           request = new SampleRequest(String.valueOf(i));
           controller.addHandler(request,handler);
           response = controller.processRequest(request);
           assertNotNull(response);
           assertNotSame(ErrorResponse.class,response.getClass());
        }
    }

}
