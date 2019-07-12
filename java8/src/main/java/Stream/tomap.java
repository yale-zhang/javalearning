package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class tomap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Supplier<Map<Integer,Integer>> mapSupplier = () -> list.stream().collect(Collectors.toMap(x->x, y-> y * y));

        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(x -> x, y -> y, (x, y) -> x + y, mapSupplier));
        Map<Integer, Integer> integerIntegerMap = mapSupplier.get();
        //integerIntegerMap.forEach((v,m)->System.out.println(v+" "+m));
        System.out.println(integerIntegerMap);
        System.out.println(map);

    }
}
