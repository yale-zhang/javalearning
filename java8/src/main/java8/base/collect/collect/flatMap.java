package java8.base.collect.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName flatMap
 * @Description TODO
 * @Author yale
 * @Date 2019/1/10 13:59
 * @Version 1.0
 **/
public class flatMap {

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
       /* Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());*/


        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    // 3

        Arrays.asList("a1","a2","b1","c2","c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",s,Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",s, Thread.currentThread().getName()));
    }

}
