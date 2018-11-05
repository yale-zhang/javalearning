package java8.base.collect;


import java.util.NoSuchElementException;
import java.util.Optional;
public class OptionalTest {

   /* @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> empty = Optional.empty();
        empty.get();
    }*/

    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        //User user = new User();
        //Optional<User> empty = Optional.of("");
    }

    public static void main(String[] args) {
        //of,ofNullable
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("sanaulla");
        Optional<String> empty = Optional.ofNullable(null);
        //isPresent
        if (name.isPresent()){
            System.out.println(name.get());
        }
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        //ifPresent
        //ifPresent方法接受lambda表达式作为参数。
        //lambda表达式对Optional的值调用consumer进行处理。
        name.ifPresent((value)->{
            System.out.println("The length of the value is: " + value.length());
        });

        //orElse 如果有值则将其返回，否则返回指定的其它值。
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is no value present!"));

        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
        //orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Default Value
        System.out.println(empty.orElseGet(() -> "Default Value"));
        //输出：Sanaulla
        System.out.println(name.orElseGet(() -> "Default Value"));

        //orElseThrow
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));


    }

}
