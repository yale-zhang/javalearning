package design_pattern.proxy;

public class RealSubject implements Subject {
    @Override
    public void sayhi() {
        System.err.print("Hi,guys!");
    }
    @Override
    public void saybaybay() {
        System.err.print("baybay,guys!");
    }
}
