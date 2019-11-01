package java8.base.collect;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest extends TestCase {
    @Test
    public void testMapCompute(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"");
        map.compute(1,(k,v) ->(v == null)? "msg":v.concat("msg"));
        assertEquals("amsg",map.get(1));
    }
    @Test
    public void testss(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"");
        map.compute(1,(k,v) ->(v == null)? "msg":v.concat("msg"));
        assertEquals("amsg",map.get(1));
    }
    @Test
    public void testMapForEach(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"");

        //1,forEach使用consumer来对map中的每个元素进行操作,执行通用任务。
        map.forEach((k,v) -> System.out.print("key 1:"+k+"; value 1:"+v));
        //2,使用功能性函数在map里执行代码
        map.computeIfPresent(3,(x,y) -> x + y.concat("x"));

        System.out.println();
        for (Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.print("key 2:"+entry.getKey()+"; value 2:"+entry.getValue());
        }
        System.out.println();
        //3,合并map中的实体
        //此时map.get(9)=null
        map.merge(9,"val_99",(v,newv) ->v.concat(newv));
        System.out.println("key 9:"+map.get(9));

        map.replace(9,"val");
        System.out.println("key 10:"+map.get(9));

        Collection<String> values = map.values();

        System.out.println();
        for (int i =4 ; i<10; i++){
            //putIfAbsent使得我们不用写是否为null值的检测语句
            map.putIfAbsent(i,"val_"+i);
        }
    }
    @Test
    public void testGetordefault(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"");
        //returns the value to which the specified key is mappded, or defaultValue if the map contains no mapping for
        //the key
        String c = map.getOrDefault(5, "c");
        System.out.println(c);

            Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
            if(iterator.hasNext()){
                Map.Entry<Integer, String> entry = iterator.next();
            }
    }
    @Test
    public void testMaps(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"");
        map.put(1,"c");
        for (Map.Entry<Integer, String> entries:map.entrySet()){
            entries.setValue("d");
        }
        map.forEach((k,v) -> System.out.println("key :"+k+"; value:"+v));
    }
    @Test
    public void test(){
        BigDecimal scale = BigDecimal.ZERO.setScale(2);
        System.out.print(scale);
    }
}
