package Guava;

import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

public class Iterable {
    @Test
    public void Iterables(){
        java.lang.Iterable<Integer> concat = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6),
                Ints.asList(6, 7, 8));
        // concatenated包括元素 1, 2, 3, 4, 5, 6
        Integer lastAdded = Iterables.getLast(concat);
        // Integer theElement = Iterables.getOnlyElement(concat);
        System.out.println("lastAdded:"+lastAdded+"");//lastAdded:6
        //切割划分
        java.lang.Iterable<List<Integer>> partitionList = Iterables.partition(concat, 3);
        partitionList.forEach(partition ->System.out.println(partition)); //[1, 2, 3] [4, 5, 6]
        //发生频次
        int frequency = Iterables.frequency(concat, 6);
        System.out.println("frequency:"+frequency+"");//frequency : 2

        Integer  index= Iterables.get(concat, 10,0);
        System.out.println("index:"+index+"");//index : 6

    }
}
