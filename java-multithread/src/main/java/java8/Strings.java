package java8;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strings {
    public static void main(String[] args) {
        String join = String.join(":", "c","a", "b");
        //System.out.print(join);

        String collect = join.chars().distinct().mapToObj(c -> String.valueOf((char) c))
                .sorted().collect(Collectors.joining());
       // System.out.print(collect);

        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        List<String> strings = Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate()).collect(Collectors.toList());

        strings.forEach(i ->System.out.println(i));

        System.out.println(Integer.MAX_VALUE);
    }
}
