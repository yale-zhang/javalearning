package stream;

import java.util.Arrays;
import java.util.List;

public class Stream {

    public static void main(String[] args) {
        //迭代 numbers 集合中的元素，但仅迭代至找到满足它的两个要求（大于 10 且是偶数）的元素。
        // 找到第一个数字后，就不会再处理其他值。
        List<Integer> numbers = Arrays.asList(2, 5, 8, 15, 12, 19, 50, 23);
        System.out.println(
                numbers.stream()
                .peek(e -> System.out.println("processing" +"  "+ e))
                .filter(e -> e > 10)
                .filter(e -> e % 2 ==0)
                .map(e -> e * 2)
                .findFirst()
                .map(e -> "the value is"+ "  "+e)
                .orElse("no value found")
        );
    }
}
