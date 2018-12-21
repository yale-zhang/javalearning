package java8.function;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName function
 * @Description TODO
 * @Author yale
 * @Date 2018/12/20 13:05
 * @Version 1.0
 **/
public class function {

    //一个接收函数的函数
    public static int totalSelectedValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }
    //创建并返回 Predicate 来验证给定值是否为奇数的函数
    public static Predicate<Integer> createIsOdd() {
        //Predicate<Integer> check = (Integer number) -> number % 2 != 0;
        return number -> number%2 !=0;
    }
    //API which accepts an implementation of
    //Function interface
    public static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){
        int newValue = function.apply(valueToBeOperated);
        /*
         * Do some operations using the new value.
         */
        System.out.println(newValue);
    }

    public static void main(String[] args) {
        List<Integer> values = Lists.newArrayList(1,2,3,4,5,6,7,8,9,0);

        int i = totalSelectedValues(values, e -> e % 2 == 0);
        System.out.println(i);

        boolean test = createIsOdd().test(5);
        System.out.println(test);

        //Predicate<Integer> isGreaterThan50 = e -> e > 5;

        Function<Integer,Predicate<Integer>> isGreateThan = pivot -> candidate -> candidate > pivot;
        List<Integer> integers1 = values.stream().filter(isGreateThan.apply(3))
                .collect(Collectors.toList());
        //integers1.forEach(System.out::println);
        List<Integer> integers = values.stream().filter(isGreateThan.apply(5)).map(e -> e * 2)
                .collect(Collectors.toList());
        //integers.forEach(System.out::println);

        int incr = 20;
        int myNumber = 10;
        modifyTheValue(myNumber, val-> val + incr);
        myNumber = 15;
        modifyTheValue(myNumber, val-> val * 10);
        modifyTheValue(myNumber, val-> val - 100);
        modifyTheValue(myNumber, val-> "somestring".length() + val - 100);

    }

}
