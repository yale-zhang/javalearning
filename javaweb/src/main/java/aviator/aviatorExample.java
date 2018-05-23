package aviator;

import aviator.function.AddFunction;
import aviator.function.GetFirstNonNullFunction;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.*;

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
        Long result3 = (Long) AviatorEvaluator.exec("string.length('hello')");
        Boolean result4 = (Boolean) AviatorEvaluator.exec("string.contains(\"test\",string.substring('hello',1,2))");

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
    public static void aviatorFunction(){
        /**
         * 自定义函数
         * 实现com.googlecode.aviator.runtime.type.AviatorFunction接口, 并注册到AviatorEvaluator即可使用.
         *
         * 根据你的方法的参 数个数, 继承AbstractFunction类并override相应方法即可。
         * 注册函数通过AviatorEvaluator.addFunction方法, 移除可以通过removeFunction
         * ex.AviatorObject call(Map<String, Object> env, AviatorObject arg1)
         *
         * 加载自定义函数列表
         *
         * 1,AviatorEvaluator.addFunction 来添加自定义函数
         * 2,在classpath下放置一个配置文件 aviator_functions.config，内容是一行一行的自定义函数类的完整名称
         * ex.# 这是一行注释
             com.example.TestFunction
             com.example.GetFirstNonNullFunction
            自定义文件路径，可以通过传入环境变量
            -Dcom.googlecode.aviator.custom_function_config_file=xxxx.config来设置。
         */

        //注册函数
        //AviatorEvaluator.addFunction(new AddFunction());
        AviatorEvaluator.addFunction(new GetFirstNonNullFunction());
        //System.out.println(AviatorEvaluator.execute("add(1, 2)"));
        System.out.println(AviatorEvaluator.execute("getFirstNonNull(1,2,3,4,1,5)"));

        /**
         * 编译表达式
         * 通过compile方法可以将表达式编译成Expression的中间对象, 当要执行表达式的时候传入env并调用Expression的execute方法即可。
         *
         * 表达式中使用了括号来强制优先级, 这个例子还使用了>用于比较数值大小, 比较运算符!=、==、>、>=、<、<=不仅可以用于数值,
         * 也可以用于String、Pattern、Boolean等等, 甚至是任何用户传入的两个都实现了java.lang.Comparable接口的对象之间。
         *
         * 编译后的结果你可以自己缓存, 也可以交给 Aviator 帮你缓存, AviatorEvaluator内部有一个全局的缓存池,
         * 如果你决定缓存编译结果, 可以通过: public static Expression compile(String expression, boolean cached)
         * 将cached设置为true即可, 那么下次编译同一个表达式的时候将直接返回上一次编译的结果。使缓存失效通过:
         *
         * public static void invalidateCache(String expression)
         */
        String expression = "a-(b-c)>100";
        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        // 执行表达式
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);  // false
    }

    public static void aviatorArrayOrSet(){
        final List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add(" world");
        final int[] array = new int[3];
        array[0] = 0;
        array[1] = 1;
        array[2] = 3;
        final Map<String, Date> map = new HashMap<String, Date>();
        map.put("date", new Date());
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("list", list);
        env.put("array", array);
        env.put("mmap", map);

        System.out.println(AviatorEvaluator.execute("list[0]+list[1]", env));
        System.out.println(AviatorEvaluator.execute("array[0]+array[1]+array[2]", env));
        System.out.println(AviatorEvaluator.execute("'today is ' + mmap.date ", env));
        // assertEquals("a", AviatorEvaluator.exec("string.split(s,',')[0]", "a,b,c,d"));

        //正则表达式
        /**
         * email与正则表达式/([\\w0-8]+@\\w+[\\.\\w+]+)/通过=~操作符来匹配,结果为一个 Boolean 类 型,
         * 因此可以用于三元表达式判断,匹配成功的时候返回$1,指代正则表达式的分组 1,也就是用户名,否则返回unknown
         *
         * Aviator 在表达式级别支持正则表达式,通过//括起来的字符序列构成一个正则表达式,正则表达式可以用于匹配(作为=~的右操作数)、比较大小。
         * 但是匹配仅能与字符串进行匹配。匹配成功后, Aviator 会自动将匹配成功的捕获分组(capturing groups)
         * 放入 env ${num}的变量中,其中$0 指代整个匹配的字符串,而$1表示第一个分组，$2表示第二个分组以此类推。
         *
         * 分组捕获放入 env 是默认开启的，因此如果传入的 env 不是线程安全并且被并发使用，可能存在线程安全的隐患。关闭分组匹配，可以通过
         * AviatorEvaluator.setOption(Options.PUT_CAPTURING_GROUPS_INTO_ENV, false);来关闭
         */
        String email = "killme2008@gmail.com";
        Map<String, Object> env1 = new HashMap<String, Object>();
        env1.put("email", email);
        String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env1);
        System.out.println(username); // killme2008
    }
    public static void syntactic_Sugar(){
        //变量语法糖
        /**
         * 对于深度嵌套并且同时有数组的变量访问，例如 foo.bars[1].name，从 3.1.0 版本开始， aviator 通过引用变量来支持（quote variable)：
         AviatorEvaluator.execute("'hello,' + #foo.bars[1].name", env)
         引用变量要求以 # 符号开始，并且变量名中不能包含其他变量，也就是并不支持 #foo.bars[i].name 这样的访问
         */
        variable var = new variable(100, 3.14f, new Date());
        Map<String, Object> env2 = new HashMap<String, Object>();
        env2.put("foo", var);
        System.out.println(AviatorEvaluator.execute("'foo.i = '+foo.i", env2));   // foo.i = 100
        System.out.println(AviatorEvaluator.execute("'foo.f = '+foo.f", env2));
        System.out.println(AviatorEvaluator.execute("'foo.date.year = '+(foo.date.year+1990)", env2));

        /**
         * nil对象
         * nil是 Aviator 内置的常量,类似 java 中的null,表示空的值。
         *
         * 在 java 中null只能使用在==、!=的比较运算符,而nil还可以使用>、>=、<、<=等比较运算符。
         * Aviator 规定,任何对象都比nil大除了nil本身。用户传入的变量如果为null,将自动以nil替代。
         */
        AviatorEvaluator.execute("nil == nil");   //true
        AviatorEvaluator.execute(" 3> nil");      //true
        AviatorEvaluator.execute(" true!= nil");  //true

        /**
         * 字面量表示
         *
         * big int和decimal的表示与其他数字不同,两条规则:
         * 以大写字母N为后缀的整数都被认为是big int,如1N,2N,9999999999999999999999N等, 都是big int类型。
         * 超过long范围的整数字面量都将自动转换为big int类型。
         * 以大写字母M为后缀的数字都被认为是decimal, 如1M,2.222M, 100000.9999M等, 都是decimal类型。
         *
         * 给浮点数添加 M 后缀比较繁琐，也可以强制所有浮点数解析为 BigDecimal，通过代码开启下列选项即可：
         * AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
         */

        /**
         * 类型转换和提升
         *
         * 当big int或者decimal和其他类型的数字做运算的时候,按照long < big int < decimal < double的规则做提升,
         * 也就是说运算的数字如果类型不一致, 结果的类型为两者之间更“高”的类型。
         *
         * decimal的计算精度
         *
         *  Java的java.math.BigDecimal通过java.math.MathContext支持特定精度的计算,任何涉及到金额的计算都应该使用decimal类型。
         *  默认 Aviator 的计算精度为MathContext.DECIMAL128,你可以自定义精度, 通过:
         AviatorEvaluator.setOption(Options.MATH_CONTEXT, MathContext.DECIMAL64);
         即可设置,更多关于decimal的精度问题请看java.math.BigDecimal的 javadoc 文档。

         匹配运算符

         匹配运算符=~用于String和Pattern的匹配,它的左操作数必须为String,右操作数必须为Pattern。
         匹配成功后,Pattern的分组将存于变量$num,num为分组索引。

         位运算符
         Aviator 支持所有的 Java 位运算符,包括&, |, ^, ~, >>, <<, >>>。

         选项列表

         AviatorEvaluator.setOption(opt, val) 支持的运行时选项包括：

         OPTIMIZE_LEVEL： 优化级别，可以是 AviatorEvaluator.EVAL 或者 AviatorEvaluator.COMPILE，
            分别表示执行速度优先还是编译速度优先。默认是 EVAL。执行速度优先，会在编译期做一些简单优化，适合表达式相对固定，编译后长期重复运行的场景。
         MATH_CONTEXT： BigDecmail 的运算精度，默认是 java.math.MathContext.DECIMAL128。
         PUT_CAPTURING_GROUPS_INTO_ENV：是否捕获正则表达式匹配的分组，默认为 true，如果无需获取匹配分组结果，可关闭该选项获得些许性能提升。
         ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL：将浮点数都解析为 BigDecimal，默认为 false 关闭。
         TRACE_EVAL：跟踪表达式执行过程，方便调试，默认为 false 关闭。
            打开后将在标准输出打印每个表达式的求值过程，该选项极大地影响性能，并且将关闭逻辑运算符的短路运算，请不要在生产环境打开。
         */
    }

    public static void seqlib(){
        /**
         * 强大的seq库
         *
         * 在 aviator 中, 数组以及java.util.Collection下的子类都称为seq,可以直接利用 seq 库进行遍历、过滤和聚合等操作。
         */
        Map<String, Object> env = new HashMap<String, Object>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(20);
        list.add(10);
        env.put("list", list);
        Object result = AviatorEvaluator.execute("count(list)", env);//求长度: count(list)
        System.out.println(result);  // 3
        //求和: reduce(list,+,0), reduce函数接收三个参数,第一个是seq,第二个是聚合的函数,如+等,第三个是聚合的初始值
        result = AviatorEvaluator.execute("reduce(list,+,0)", env);
        System.out.println(result);  // 33
        //过滤: filter(list,seq.gt(9)), 过滤出list中所有大于9的元素并返回集合; seq.gt函数用于生成一个谓词,表示大于某个值
        result = AviatorEvaluator.execute("filter(list,seq.gt(9))", env);
        System.out.println(result);  // [10, 20]
        //判断元素在不在集合里: include(list,10)
        result = AviatorEvaluator.execute("include(list,10)", env);
        System.out.println(result);  // true
        //排序: sort(list)
        result = AviatorEvaluator.execute("sort(list)", env);
        System.out.println(result);  // [3, 10, 20]
        //遍历整个集合: map(list,println), map接受的第二个函数将作用于集合中的每个元素,这里简单地调用println打印每个元素
        AviatorEvaluator.execute("map(list,println)", env);
        /**
         seq.some(list, pred) 当集合中只要有一个元素满足谓词函数 pred 返回 true，立即返回 true，否则为 false。
         seq.every(list, pred) 当集合里的每个元素都满足谓词函数 pred 返回 true，则结果为 true，否则返回 false。
         seq.not_any(list, pred)，当集合里的每个元素都满足谓词函数 pred 返回 false，则结果为 true，否则返回 false。
         以及 seq.or(p1, p2, ...) 和 seq.and(p1, p2, ...) 用于组合 seq.gt、seq.lt 等谓词函数。
         */

        /**
         * 调试信息
         *
         * 如果想查看每个表达式生成的字节码，可以通过打开 Trace 选项：
         import com.googlecode.aviator.Options;
         AviatorEvaluator.setOption(Options.TRACE, true);
         默认是打印到标准输出,你可以改变输出指向:
         AviatorEvaluator.setTraceOutputStream(new FileOutputStream(new File("aviator.log")));
         */
    }


    public static void main(String[] args) {
       // TestAviator();
       // aviatorFunction();
        aviatorArrayOrSet();
        seqlib();
    }
}
