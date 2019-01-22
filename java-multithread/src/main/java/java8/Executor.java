package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author yale
 * @Date 2019/1/14 9:45
 * @Version 1.0
 **/
public class Executor {
    public static void main(String[] args) {
        ExecutorService executor  = Executors.newSingleThreadExecutor();
        executor .submit(()->{
            String threadName = Thread.currentThread().getName();
            System.err.print("hello  "+threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
