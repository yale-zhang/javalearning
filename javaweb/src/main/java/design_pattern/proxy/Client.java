package design_pattern.proxy;

public class Client {
    public static void main(String[] args){
        StaicProxy staicProxy = new StaicProxy();
        staicProxy.sayhi();
        staicProxy.saybaybay();
    }
}
