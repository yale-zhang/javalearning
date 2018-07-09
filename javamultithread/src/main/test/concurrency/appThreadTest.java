package concurrency;

import concurrency.thread.MyThreadFactory;
import org.testng.annotations.Test;

public class appThreadTest {
    @Test
    public void testAppthread(){
        Runnable runnable = new Runnable(){
            public void run()
            {
                System.out.println("Appthread, 时间为" + System.currentTimeMillis());
            }
        };
        MyThreadFactory testThread = new MyThreadFactory("testThread");
        testThread.newThread(runnable);
    }
}
