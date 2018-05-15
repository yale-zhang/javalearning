package multithread;

import java.util.concurrent.*;

public class test {
    public static void main(String[] args)
    {
        staticthreads();
        //MyThreadTest();
        //CyclicBarrierThreads();
        //callableFuture();
        //callableFutureTask();
    }

    public static void staticthreads(){
        staticthread staticthread = new staticthread();
        staticthread.start();
    }

    public static void MyThreadTest(){
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i=0;i<5;i++){
            System.out.print(Thread.currentThread().getName()+"在运行！");
        }
    }
    /**
     * CyslicBarrier
     */
    public static void CyclicBarrierThreads(){
        Runnable runnable = new Runnable()
        {
            @Override
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

    /**
     * callable和runnable 差不多两者都是为那些其实例可能被另一个线程执行的类设计的，
     * 差别在于runnable不会返回线程运算结果，calable可以
     *
     * future
     * future 是个接口 表示异步计算的结果，他提供了检查计算是否完成的方法，以等待计算完成，并获取计算的结果
     *
     * Callable+Future
     * 看到任意一个利用Callable接口submit上去的任务，只要有一个Future接受它，
     * Future便可以在程序任何地点尝试去获取这条线程返回出去的数据，时间可以比对一下，正好10000ms，即10s
     */
    public static void callableFuture(){
        try {
            ExecutorService es = Executors.newCachedThreadPool();
            CallableThread ct = new CallableThread();
            Future<String> f = es.submit(ct);
            es.shutdown();
            Thread.sleep(5000);
            System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());
            String str = f.get();
            System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void callableFutureTask(){
        try {
            ExecutorService es = Executors.newCachedThreadPool();
            CallableThread ct = new CallableThread();
            FutureTask<String> f = new FutureTask<String>(ct);
            es.submit(f);
            es.shutdown();

            Thread.sleep(5000);
            System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());
            String str = f.get();
            System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
