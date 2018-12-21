package java_util_cocurrency_user_guide;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BlockingQueueExample {
    public static void main(String[] args) throws Exception {

        System.out.print("Get set...");
        /*for(int i = 1; i < 4; i++) {
            System.out.print(i + "...");
        }*/
        IntStream.rangeClosed(1,4).forEach(System.out::print);

        int sum = IntStream.iterate(1, e -> e + 3).limit(34).sum();
        System.out.print(sum + "...");

        List<String> names = Lists.newArrayList("yale", "Tom", "");

        Function<String, Integer> lengthFunction =(string) -> string.length();

        Predicate<String> allCaps =(string) -> CharMatcher.JAVA_UPPER_CASE.matchesAllOf(string);

       /* Multiset<Integer> lengths = HashMultiset.create(
                Iterables.transform(Iterables.filter(strings, allCaps), lengthFunction));*/
    }

}
