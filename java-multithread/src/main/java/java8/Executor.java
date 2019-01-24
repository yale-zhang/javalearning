package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author yale
 * @Date 2019/1/14 9:45
 * @Version 1.0
 **/
public class Executor {
    public static void main(String[] args) {
        //executor();
        //invokeAll();
        //invokeAny();
        ScheduledExecutor();
    }

    public static void ScheduledExecutor(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
    }

    public static void executor(){
         ExecutorService executor  = Executors.newSingleThreadExecutor();
        executor.submit(()->{
            String threadName = Thread.currentThread().getName();
            System.err.println("hello  "+threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    public static void invokeAll(){
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void invokeAny(){
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = null;
        try {
            result = executor.invokeAny(callables);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

   private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
