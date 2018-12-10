package Guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import org.junit.Test;

public class MultisetTest {
    @Test
    public void Multisets(){
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);
        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        multiset1.containsAll(multiset2); //返回true；因为包含了所有不重复元素，
        multiset2.forEach(multiset ->System.out.println(multiset));

        //虽然multiset1实际上包含2个"a"，而multiset2包含5个"a"
        Multisets.containsOccurrences(multiset1, multiset2); // returns false
        multiset2.remove(multiset1); // multiset2 现在包含3个"a"
        multiset2.removeAll(multiset1);//multiset2移除所有"a"，虽然multiset1只有2个"a"
        multiset2.isEmpty(); // returns true
    }
}
