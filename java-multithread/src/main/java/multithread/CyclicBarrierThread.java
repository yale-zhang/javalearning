package multithread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread {

    private CyclicBarrier cb;
    private int sleepSecond;

    public CyclicBarrierThread(CyclicBarrier cb, int sleepSecond) {
        this.cb = cb;
        this.sleepSecond = sleepSecond;
    }
    @Override
    public void run()
    {
        try {
            System.out.println(this.getName() + "运行了");
            Thread.sleep(sleepSecond * 1000);
            System.out.println(this.getName() + "准备等待了, 时间为" + System.currentTimeMillis());
            cb.await();
            System.out.println(this.getName() + "结束等待了, 时间为" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
