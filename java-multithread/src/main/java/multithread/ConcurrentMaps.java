package multithread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMaps {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        //map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
        //search(map);
        reduce(map);

    }
    public static void reduce(ConcurrentHashMap<String, String> map){
        String result = map.reduce(1,
                (key, value) -> key + "=" + value,
                (s1, s2) -> s1 + ", " + s2);
        System.out.println("Result: " + result);
    }


    public static void search(ConcurrentHashMap<String, String> map){

        /*map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("foo"));   // boo was bar*/

       /* map.forEach(1, (key, value) ->
                System.out.printf("key: %s; value: %s; thread: %s\n",
                        key, value, Thread.currentThread().getName()));*/

      /*  String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        */
        String result = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result);
    }
}
