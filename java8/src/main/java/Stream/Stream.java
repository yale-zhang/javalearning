package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stream {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("add2");
        stringCollection.add("aaa2");
        stringCollection.add("abb1");
        stringCollection.add("aaa1");
        stringCollection.add("abb3");
        stringCollection.add("acc");
        stringCollection.add("abb2");
        stringCollection.add("add1");

        System.out.println(stringCollection);

        // filter ,sorted
       /* stringCollection
                .stream()
                .sorted()
                .filter((s)->s.startsWith("a"))
                .forEach(System.out::println);*/
        //map
        /*stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b)->a.compareTo(b))
                .forEach(System.out::println);*/

        //match 检查某谓词是否匹配
        boolean a = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("b"));
        System.out.println(a);

        boolean b = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(b);

        //reduce
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

    }
}
