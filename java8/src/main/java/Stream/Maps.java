package Stream;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        System.out.print(map);
       // map.forEach((id, val) -> System.out.println(val));
      /*  map.forEach((id,val) ->{
            //System.out.println(val);
            if ("val0".equals(val)){
                System.out.print("true");
            }
        });*/

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);
        System.out.println(map.get(3));

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);
        System.out.println(map.get(9));

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true
        System.out.println(map.containsKey(23));
        System.out.println(map.get(23));

        map.remove(3,"val33");
        System.out.println(map.get(3));
    }
}
