package stream;

import com.google.common.collect.Lists;
import vo.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class streamTest {
    public static void main(String[] args) {
        //stream collect
        User user =new User("1","yale",20);
        User user11 =new User("3","yale",30);
        User user1 =new User("2","yale",18);
        User user2 =new User("1","tom",16);
        User user33 =new User("3","tom",20);
        User user3 =new User("2","tom",14);
        List<User> userList = Lists.newArrayList(user, user1, user2, user3,user11,user33);
        //根据名称分组
        Map<String, List<User>> collect = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.groupingBy(User::getName));
        collect.forEach((k,v)->System.out.println("根据名称分组->key:"+k+"    "+"value:"+v));
        //先根据名称分组，然后求每组平均分
        Map<String, Double> doubleMap = userList.stream().collect(Collectors.groupingBy(User::getName, Collectors.averagingDouble(User::getAge)));
        doubleMap.forEach((k,v)->System.out.println("先根据名称分组，然后求每组平均分->key:"+k+"    "+"value:"+v));
        //分区
        Map<Boolean, List<User>> listMap = userList.stream().collect(Collectors.partitioningBy(item -> item.getAge() >= 18));
        listMap.forEach((k,v)->System.out.println("分区 ->key:"+k+"    "+"value:"+v));
        //先根据名称分组再根据分数分组
        Map<String, Map<Integer, List<User>>> stringMapMap = userList.stream().collect(Collectors.groupingBy(User::getName, Collectors.groupingBy(User::getAge)));
        stringMapMap.forEach((k,v)->System.out.println("先根据名称分组再根据分数分组 ->key:"+k+"    "+"value:"+v));
    }
}
