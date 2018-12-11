package Guava;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Iterator;

public class MapTest {

    @Test
    public void maps(){
        //如果索引值不是独一无二的，请参见下面的Multimaps.index方法。
        Iterator<String> iterator = Lists.newArrayList("1", "22", "333","4444").iterator();
        //这个方法返回一个Map，键为Function返回的属性值，值为Iterable中相应的元素，因此我们可以反复用这个Map进行查找操作。
        ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(iterator,
            new Function<String, Integer>() {
                public Integer apply(String string) {
                    return string.length();
            }
        });
        stringsByIndex.forEach((k,v)->System.out.println(k+"    "+v));
        //如果索引值不是独一无二的，请参见下面的Multimaps.index方法。

    }
}
