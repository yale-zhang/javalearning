package java8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName test
 * @Description TODO
 * @Author yale
 * @Date 2019/1/14 13:42
 * @Version 1.0
 **/
public class test {

    public static void main(String[] args) {
       List<String> strings = Lists.newArrayList("1", "11");

       for (String str:strings){
           if ("1".startsWith(str)){
               System.err.print(str+"           ");
           }
       }
    }
}
