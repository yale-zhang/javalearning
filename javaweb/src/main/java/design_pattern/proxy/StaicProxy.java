package design_pattern.proxy;

public class StaicProxy implements Subject {
    private RealSubject realSubject = null;
    @Override
    public void sayhi() {
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.sayhi();
    }

    @Override
    public void saybaybay() {
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.saybaybay();
    }
}
