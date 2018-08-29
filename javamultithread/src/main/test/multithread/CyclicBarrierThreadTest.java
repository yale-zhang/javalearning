package multithread;

import org.testng.annotations.Test;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThreadTest{
    @Test
    public void CyclicBarrierTest(){
        Runnable runnable = new Runnable(){
            public void run()
            {
                System.out.println("CyclicBarrier的所有线程await()结束了，我运行了, 时间为" + System.currentTimeMillis());
            }
        };
        CyclicBarrier cb = new CyclicBarrier(3, runnable);
        CyclicBarrierThread cbt0 = new CyclicBarrierThread(cb, 3);
        CyclicBarrierThread cbt1 = new CyclicBarrierThread(cb, 6);
        CyclicBarrierThread cbt2 = new CyclicBarrierThread(cb, 9);
        cbt0.start();
        cbt1.start();
        cbt2.start();
    }
}
