package java8.functionalInterface;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @ClassName Order
 * @Description TODO
 * @Author yale
 * @Date 2018/12/19 17:23
 * @Version 1.0
 **/
public class Order {
    List<OrderItem> items;

    public Order(List<OrderItem> orderItems) {
        items = orderItems;
    }

    public void transformAndPrint(Transformer<Stream<OrderItem>> orderIteams){
        orderIteams.validate(items.stream()).forEach(System.out::println);
    }

    public void transformAndPrint(Function<Stream<OrderItem>, Stream<OrderItem>> transformOrderItems) {
        transformOrderItems.apply(items.stream()).forEach(System.out::println);
    }
}
