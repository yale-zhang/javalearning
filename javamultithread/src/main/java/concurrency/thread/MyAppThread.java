package concurrency.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  定制Thread基类
 *    为线程指定名字，设置自定义的UncaughtExceptionHandler向Logger中写入信息
 *    维护一些统计信息(包括有多少个线程被创建和销毁)，以及在线程创建或者终止时把调试信息写入日志。
 */
public class MyAppThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(MyAppThread.class);

    private static final String DEFAULT_NAME = "MyAppThread";

    private static volatile boolean debugLifecycle = false;

    private static final AtomicInteger created = new AtomicInteger(0);

    private static final AtomicInteger alive = new AtomicInteger(0);
    //为线程指定名字
    public MyAppThread(Runnable target) {
        super(target,DEFAULT_NAME);
    }
    //设置自定义的UncaughtExceptionHandler向Logger中写入信息 维护一些统计信息
    public MyAppThread(Runnable target, String poolname) {
        super(target, poolname+"-"+created.incrementAndGet());
        setUncaughtExceptionHandler(
            new Thread.UncaughtExceptionHandler(){
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    logger.error("Uncaught in thread {}",t.getName(),e);
                }
            }
        );
    }

    @Override
    public void run() {
        //复制 debug 标志以确保一致的值
        boolean debug = debugLifecycle;
        if (debug){
            logger.error("Created '{}' thread",getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug){
                logger.error("Exiting '{}' thread",getName());
            }
        }
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean isDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean debug) {
        debugLifecycle = debug;
    }
}
