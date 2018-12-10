package java8.base.collect.stream;

import org.junit.Test;
import vo.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamListTest {

    public List<User> getDate(){
        List<User> list =new ArrayList<>();
        User user11 = new User("001","yale",12);
        User user22 = new User("002","yale",10);
        User user1 = new User("001","tom",18);
        User user2 = new User("002","tom",16);
        list.add(user11);
        list.add(user22);
        list.add(user1);
        list.add(user2);
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
    //1,分组
    // List里的元素，以某个属性来分组 eg 将id相同的分组   list->map
    @Test
    public void groupbyTest(){
        List<User> list = getDate();
        Map<String, List<User>> collect = list.stream()
                .collect(Collectors.groupingBy(User::getId));
        collect.forEach((k,v)->System.out.println("key:"+k+" "+"value"+v.toString()));
    }
    //2,list 转map
    //id 为key，user对象为value
    @Test
    public void list2mapTest() {
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        List<User> list = getDate();
        Map<String, User> collect = list.stream()
                .collect(Collectors.toMap(User::getId, a -> a, (k1, k2) -> k1));
        collect.forEach((k,v)->System.out.println("key:"+k+" "+"value"+v.toString()));
    }
    //3,distinct 去重数据中的重复数据，4,limit ,5,skip

    //6,sorted 对流的元素进行排序
    @Test
    public void studentTest(){
        List<User> list = getDate();
        List<User> collect = list.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
        collect.forEach(s -> System.out.println(s.getName()+"   "+s.getAge()));
    }
    //7 映射 map和flatmap
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
    //8 flatMap与map的区别在于 flatmap是将流中的每个值都转成一个个流，然后再将流扁平化成为一个流
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

    //9 归约 collect(Collectors.toList())对数据进行封装，如果目标返回的不是一个新的集合，而是希望对参数化后的集合进一步运算
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

