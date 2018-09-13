#### Java 多线程模块
   - [Java 8并发工具包](src/main/java/concurrency/jdk/concurrent.MD)
    
   - [自定义的线程工厂，定制的Thread基类](src/main/java/concurrency/thread)
    
   - [CompletableFuture](src/main/java/java8/multithread.java)  
   
  |  描叙  | Future | FutureTask | CompletionService | CompletableFuture |  
  | ------ | ------ | ------ | ------ | ------ |  
  | 原理 | Future接口 | 接口RunnableFuture的唯一实现类，RunnableFuture接口继承自Future+Runnable | 内部通过阻塞队列+FutureTask接口 | JDK8实现了Future, CompletionStage两个接口 |
  | 多任务并发执行 | 支持 | 支持 | 支持 | 支持 |
  | 获取任务结果的顺序 | 按照提交顺序获取结果 | 未知 | 支持任务完成的先后顺序 | 支持任务完成的先后顺序 |
  | 异常捕捉 | 自己捕捉 | 自己捕捉 | 自己捕捉 | 原生API支持，返回每个任务的异常 |
  | 建议 | CPU高速轮询，耗资源，可以使用蛋不推荐 | 功能不对口，并发任务这一块多套一层，不推荐使用 | 推荐使用，没有JDK8 CompletableFuture之前最好的方案 | api极端丰富,配合流式编程 |
    
   
    
   ###### 参考文档
   * [线程工厂(自定义的线程工厂，定制的Thread基类)][线程工厂]
   
   [线程工厂]:https://github.com/EdwardLee03/Java_Concurrency_In_Practice/blob/391f46fd4894d0f7153882de381c08f6a52496da/src/main/java/com/concurrency/thread/MyAppThread.java#L15