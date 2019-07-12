package java8.functionalInterface;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @ClassName Sample
 * @Description TODO
 * @Author yale
 * @Date 2018/12/19 17:28
 * @Version 1.0
 **/
public class Sample {
    public static void main(String[] args) {
        Order order = new Order(Arrays.asList(
                new OrderItem(1, 1225),
                new OrderItem(2, 983),
                new OrderItem(3, 1554)
        ));

        order.transformAndPrint(new Transformer<Stream<OrderItem>>() {
            public Stream<OrderItem> validate(Stream<OrderItem> orderItems) {
                return orderItems.sorted(comparing(OrderItem::getPrice));
            }
        });

        //order.transformAndPrint(orderItems -> orderItems.sorted(comparing(OrderItem::getPrice)));
    }
}
