package java8.functionalInterface;

/**
 * @ClassName OrderItem
 * @Description TODO
 * @Author yale
 * @Date 2018/12/19 17:22
 * @Version 1.0
 **/
public class OrderItem {
    private final int id;
    private final int price;

    public OrderItem(int theId, int thePrice) {
        id = theId;
        price = thePrice;
    }

    public int getId() { return id; }
    public int getPrice() { return price; }

    public String toString() { return String.format("id: %d price: %d", id, price); }

}
