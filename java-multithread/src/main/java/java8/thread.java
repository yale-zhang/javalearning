package java8;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName thread
 * @Description TODO
 * @Author yale
 * @Date 2019/1/10 15:29
 * @Version 1.0
 **/
public class thread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();
        System.err.println("Done!");
    }
}
