package Guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

public class MuiltMap {
    @Test
    public void mulitMaps(){
        ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("a","1");
        ArrayList<String> list = Lists.newArrayList("1", "2");
        multimap.putAll("a",list);
        multimap.forEach((k,v)->System.out.println("key:"+k+"   "+"values:"+v));


    }
}
