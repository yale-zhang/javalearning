package exception;

import generics.Test;

import java.io.IOException;

public class ExceptionTest {

    private void fun1() throws IOException {
        throw new IOException("leve 1 Exception");
    }
   private void fun2(){
        try {
            fun1();
        } catch (IOException e) {
            throw new RuntimeException("level 2 excetion",e);
        }
    }
    public static void main(String[] args){
        try {
            new ExceptionTest().fun2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

