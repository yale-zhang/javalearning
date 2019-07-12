package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class flatMap {

    public static void main(String[] args) {
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar(f.name + "->" +  "bar" +i))
                        .forEach(f.bars::add)
                ).flatMap(f -> f.bars.stream())
                .forEach(b ->System.out.println(b.name));

        Optional.of(new Outer())
                .flatMap(o ->Optional.ofNullable(o.nested))
                .flatMap(n ->Optional.ofNullable(n.inner))
                .flatMap(i ->Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);


    }
}

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();
    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;
    Bar(String name) {
        this.name = name;
    }
}
