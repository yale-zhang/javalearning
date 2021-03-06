package Guava;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.*;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.*;

public class guavaTest {
    @Test
    public void SetTransformValues(){
        //对两个Set的取交集、并集和差集,返回了代表了这两个集合的视图
        HashSet setA = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet setB = Sets.newHashSet(4, 5, 6, 7, 8);
        Sets.SetView union = Sets.union(setA, setB);
        Sets.SetView diff = Sets.difference(setA, setB);
        union.forEach(un ->System.out.print(un +" "));
        System.out.println(" ------------");
        union.forEach(un ->System.out.print(diff +" "));
        Sets.SetView intersection = Sets.intersection(setA, setB);
        System.out.println(" ------------");
        union.forEach(un ->System.out.print(intersection +" "));
        //immutableCopy类中提供的一个便利方法来实现拷贝
        ImmutableSet immutableSet = Sets.intersection(setA, setB).immutableCopy();
        System.out.println(" ------------");
        union.forEach(un ->System.out.print(immutableSet +" "));
    }

    @Test
    public void MapTransformValues(){
        //对两个Set的取交集、并集和差集,返回了代表了这两个集合的视图
        Map mapA = Maps.newHashMap();
        mapA.put("a",1);
        mapA.put("b",2);
        mapA.put("c",3);
        Map mapB = Maps.newHashMap();
        mapB.put("a",2);
        mapB.put("c",3);

        Map mapC = Maps.newHashMap();
        mapC.put("b",2);
        MapDifference difference = Maps.difference(mapA, mapB);
        Map map = difference.entriesDiffering();
        map.forEach((k,v)->System.out.println("k:"+k+"  "+"v:"+v));  //  k:a  v:(1, 2)
        Map inCommon = difference.entriesInCommon();
        inCommon.forEach((k,v)->System.out.println("k:"+k+"  "+"v:"+v));  // k:c  v:3
        Map onlyOnLeftmap = difference.entriesOnlyOnLeft();  //返回一个不可修改的映射，其中包含左侧映射中的条目，其右侧映射中不存在键。
        onlyOnLeftmap.forEach((k,v)->System.out.println("k:"+k+"  "+"v:"+v));  // k:b  v:2
        difference.entriesOnlyOnRight();
    }

    @Test
    public void preconditionstest(){
        //验调用我们的方法的方法传参是否正确
        int count = 0;
        String count1 =null;
        //Preconditions.checkArgument(count > 0, "must be positive: %s", count);
        String integer = Preconditions.checkNotNull(count1);
        System.out.println(integer);
    }
    //Multimap -> Map<K, List<V>>
    @Test
    public void multimapTest(){
        ArrayListMultimap<Object, Object> multimap = ArrayListMultimap.create();
        System.out.println("");

    }

}
