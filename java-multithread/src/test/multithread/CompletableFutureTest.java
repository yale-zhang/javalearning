package multithread;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    @Test
    public void CompletableFuturesTest() throws ExecutionException,InterruptedException{
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        System.out.println("task doing...");
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                int i =1/0;
            } catch (Exception e) {
                //告诉completableFuture任务发生异常了
                completableFuture.completeExceptionally(e);
            }
            completableFuture.complete("ok");
        }).start();
        String s = completableFuture.get();
        System.out.println("计算结果:"+s);
    }
}
