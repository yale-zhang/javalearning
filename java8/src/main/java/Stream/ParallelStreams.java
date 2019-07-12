package Stream;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ParallelStreams {
    public static void main(String[] args) {
        //sortedComparisonTest();
        long currentTime=System.currentTimeMillis();
        List<Integer> data=new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            data.add(i);
        }

        long sum=data.stream()
                .map(i ->(int)Math.sqrt(i))
                .map(number->performComputation(number))
                .reduce(0,Integer::sum);

        System.out.println(sum);
        long endTime=System.currentTimeMillis();
        System.out.println("Time taken to complete:"+(endTime-currentTime)/(1000*60)+" minutes");
    }

    public static int performComputation(int number)
    {
        int sum=0;
        for (int i = 1; i < 1000000; i++) {
            int div=(number/i);
            sum+=div;

        }
        return sum;
    }

    private static void sortedComparisonTest() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //测量一下流对这个集合进行排序消耗的时间。
        //Sequential Sort
        long t0 = System.nanoTime();

        //long count = values.stream().sorted().count();//887ms
        long count = values.parallelStream().sorted().count();//536ms
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // sequential sort took: 899 ms
    }
}
