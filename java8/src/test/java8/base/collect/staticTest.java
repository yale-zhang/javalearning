package java8.base.collect;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class staticTest {
    //java8 允许使用static来修饰方法。静态方法只能通过接口名来调用

    @Test
    public void test(){
       String str ="0111";
       //System.out.println(Double.valueOf(str));
        System.out.println(isNumbers(str));
        System.out.println(StringUtils.isNumeric(str));
    }

    private static boolean isNumbers(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
             }
        }
        return true;
    }

    private static boolean isNumber(String s){
        try {
            Double.valueOf(s);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}
