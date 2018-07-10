# chapter 1: Java 8并发工具包简介   
    Java 8并发工具包由3个包组成，分别是java.util.concurrent、java.util.concurrent.atomic和java.util.concurrent.locks，
    提供了大量关于并发的接口、类、原子操作类、锁相关类。借助java.util.concurrent包，可以非常轻松地实现复杂的并发操作。
    
    java.util.concurrent包主要包含以下内容:
        
  - java.util.concurrent包主要包含以下内容
    - 阻塞队列(BlockingQueue)：多种阻塞队列的实现，在队列为空或满时能够阻塞消费者或生产者相关线程。  
     
      > 阻塞队列(BlockingQueue)   
       阻塞双端队列(BlockingDueue)   
       阻塞转移队列(TransferQueue)  
    - 并发容器：用于并发场景的容器类型，一般无需加锁。   
    - 线程池：创建单线程、固定大小或可缓存的线程池，支持周期性任务，也能够实现异步任务的返回。 
    - 锁：用于并发同步的锁.  
    - 原子类型：用于实现原子操作的数据类型，包括AtomicBoolean、AtomicInteger、AtomicLong、AtomicReference等 
    - 并发工具：用于并发场景的类，可以控制并发线程的同步、等待。