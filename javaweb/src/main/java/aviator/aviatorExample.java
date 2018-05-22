package aviator;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

public class aviatorExample {
    public static void TestAviator(){
        //Aviator的数值类型仅支持Long和Double, 任何整数都将转换成Long, 任何浮点数都将转换为Double, 包括用户传入的变量数值。
        /**
         * #如果开启了 ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL 选项，那么在表达式中出现的浮点数都将解析为 BigDecimal，
         * 这是为了方便一些用户要求高精度的计算，又不想额外地给浮点数加上 M 后缀标记为 BigDecimal：
         *
         *  AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
         */
        Long result = (Long) AviatorEvaluator.execute("1+2+3");

        /**
         * 使用变量-向表达式传入变量值
         *
         * 'hello '是一个Aviator的String, Aviator的String是任何用单引号或者双引号括起来的字符序列, String可以比较大小(基于unicode顺序),
         * 可以参与正则匹配, 可以与任何对象相加, 任何对象与String相加结果为String。 String中也可以有转义字符,如\n、\\、\' 等。
         *
         *   AviatorEvaluator.execute(" 'a\"b' ");           // 字符串 a"b
             AviatorEvaluator.execute(" \"a\'b\" ");         // 字符串 a'b
             AviatorEvaluator.execute(" 'hello ' + 3 ");     // 字符串 hello 3
             AviatorEvaluator.execute(" 'hello '+ unknow "); // 字符串 hello null
         */
        String yourName = "Michael";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourName", yourName);
        String result1 = (String) AviatorEvaluator.execute(" 'hello ' + yourName ", env);

        //Aviator 2.2 开始新增加一个exec方法, 可以更方便地传入变量并执行, 而不需要构造env这个map了:
        String name = "dennis";
        String result2 = (String)AviatorEvaluator.exec(" 'hello ' + yourName ", name);// hello dennis

        /**
         *  调用函数
         */
        Long result3 = (Long) AviatorEvaluator.execute("string.length('hello')");

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }


    public static void main(String[] args) {
        TestAviator();
    }
}
