package org.junit;

public interface RequestHandler {
    Response process(Request request) throws Exception;
}
