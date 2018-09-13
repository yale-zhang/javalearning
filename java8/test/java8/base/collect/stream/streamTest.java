package java8.base.collect.stream;

import org.junit.Test;
import vo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamTest {

    public List<User> getDate(){
        List<User> list =new ArrayList<>();
        User user = new User();
        user.setId("001");
        user.setName("yale");
        user.setAge(12);
        User user1 = new User();
        user1.setId("001");
        user1.setName("tom");
        user1.setAge(18);
        list.add(user);
        list.add(user1);
        return list;
    }
    // 过滤操作（fileter,distinct,limt,skip）
    //fileter  stream<T> fileter(Predicate<? super T> predicate)
    @Test
    public void getDateTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 3, 2, 6, 2, 8, 9, 2, 11, 23);
        List<Integer> collect = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        //通过Collectors.toList()指定其封装成为一个List集合返回
        collect.forEach(System.out::println);
    };
    //distinct 去重数据中的重复数据，limit，sorted 对流的元素进行排序 ,skip
    @Test
    public void studentTest(){
        List<User> list = getDate();
        List<User> collect = list.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
        collect.forEach(s -> System.out.println(s.getName()+"   "+s.getAge()));
    }
    //映射 map和flatmap
    //  除了基础的map,java8还提供了maptoDouble(ToDoubleFunction<? super T> mapper),mapToInt(ToIntFountion<? super T>) 这些流设定一些特殊的操作
    @Test
    public void mapTest(){
        List<User> list = getDate();
        String str = list.stream()
                .filter(s -> s.getName().equals("tom"))
                .map(User::getId)
                .collect(Collectors.joining(","));
         System.out.println(str);
    }
    //flatMap与map的区别在于 flatmap是将流中的每个值都转成一个个流，然后再将流扁平化成为一个流
    @Test
    public void flatmapTest(){
        String[] strs = {"java", "C#", "C++", "php", "javascrip","java"};
        List<String> collect = Stream.of(strs)
                .map(s -> s.split(","))
                .distinct()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        collect.forEach(s ->System.out.println(s+" "));
    }

    //归约 collect(Collectors.toList())对数据进行封装，如果目标返回的不是一个新的集合，而是希望对参数化后的集合进一步运算
    //reduce
    @Test
    public void userSumTest(){
        List<User> list = getDate();
        Integer reduce = list.stream()
                .map(User::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("reduce: " + reduce);
    }
}

