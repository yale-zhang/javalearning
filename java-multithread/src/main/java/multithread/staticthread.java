package multithread;

public class staticthread extends Thread{
    static {
        System.out.println("静态方法块print："+Thread.currentThread().getName());
    }
    public staticthread(){
        System.out.println("构造方法的print："+Thread.currentThread().getName());
    }

    public void run(){
        System.out.println("run()方法的print："+Thread.currentThread().getName());
    }

}
