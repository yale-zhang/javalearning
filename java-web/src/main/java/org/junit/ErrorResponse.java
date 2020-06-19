package org.junit;

public class ErrorResponse implements Response{
    private Request originalRequest;

    @Override
    public String getName() {
        return null;
    }

    private Exception originalExcetion;

    public ErrorResponse(Request originalRequest, Exception originalExcetion) {
        this.originalRequest = originalRequest;
        this.originalExcetion = originalExcetion;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginalExcetion() {
        return originalExcetion;
    }
}
