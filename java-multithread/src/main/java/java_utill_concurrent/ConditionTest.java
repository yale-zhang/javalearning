package java_utill_concurrent;

import java.util.concurrent.locks.Condition;

public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {
        Condition condition;
        Integer a = 2;
        Thread t1 = new Thread(new ThreadCondition(a));
        Thread t2 = new Thread(new ThreadCondition(a));
        t1.start();
        t2.start();
    }

    public static class ThreadCondition implements Runnable{
        Integer a = 0;
        public ThreadCondition(Integer a){
            this.a = a;
        }
        @Override
        public void run() {
            try {
                int  i = 0;
                while(i < 3){
                    synchronized (a){
                        a.notify();
                        System.out.println(Thread.currentThread().getName());
                        a.wait();
                        System.out.println("wait被唤醒");
                    }
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
