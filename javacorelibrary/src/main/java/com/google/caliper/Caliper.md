####Caliper
    Caliper是Google的开源框架用于编写，运行和查看JavaMicrobenchmarks测量的结果。
    
    *在benchmark的世界里头，分为广义的benchmark和狭义的benchmark（即microbenchmark，中文人称微基准测试）。
    广义的benchmark:
        对于一个分层的web系统来说，可能包括操作系统的、数据库的、网络交互的、应用系统里头的benchmark；
    狭义的benchmark:
        针对一个相对的小的方面来说的，比如针对java系统的microbenchmark，针对数据库负载能力的microbenchmark，针对web服务器的microbenchmark等等。
        
        
     java里头的microbenchmark又牵涉到许多java编译优化方面的benchmark处理，比如针对普通java应用系统的性能测试，
     需要预热阶段，是的JIT的优化能达到效果，系统进入稳定状态，尽量控制变量，好得出实验结果。
     当然，如果本身就是要测试jvm编译优化的，那就可以省去这步了。
     
     因而，如何知道系统什么时候进入稳定状态，JIT的优化不会对实现结果造成不必要的干扰，就得程序去处理预热阶段，可能比较复杂，
     不过还好，有人搞了一个JMH的codetool，是的在java里头进行meicrobenchmark变得异常方便。