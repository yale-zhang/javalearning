package multithread;

import java.util.concurrent.SynchronousQueue;

public class MyThread extends Thread {
    private Object lock;

    public MyThread(Object lock) {
        this.lock = lock;
    }

    public void run()
    {
        for (int i = 0; i < 5; i++)
        {

            try {
                synchronized(lock) {
                    System.out.println("开始------wait time = " + System.currentTimeMillis());
                    System.out.println(Thread.currentThread().getName() + "MyThread!");
                    System.out.println("run = " + this.isAlive());
                    //Java中有两种线程，一种是用户线程，一种是守护线程。守护线程，有一个细节注意下，setDaemon(true)必须在线程start()之前
                    System.out.println("run DaeMon = " + this.isDaemon());
                    //interrupt()方法的作用实际上是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞状态。
                    // 没有被阻塞的线程，调用interrupt()方法是不起作用的
                    System.out.println("run Interrupted = " + this.isInterrupted());
                    System.out.println("run id = " + this.getId());
                    //线程默认优先级为5，如果不手动指定，那么线程优先级具有继承性，比如线程A启动线程B，那么线程B的优先级和线程A的优先级相同。
                    System.out.println("run priority = " + this.getPriority());
                    lock.wait();
                    /*在Object对象中有三个方法wait()、notify()、notifyAll()，既然是Object中的方法，那每个对象自然都是有的。
                    在调用wait()之前，线程必须获得该对象的锁，因此只能在同步方法/同步代码块中调用wait()方法
                    和wait()一样，notify()也要在同步方法/同步代码块中调用。
                    wait()方法可以使调用该线程的方法释放共享资源的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒。
                    notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态
                    notifyAll()方法可以使所有正在等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态
                     */
                    System.out.println("结束------wait time = " + System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
