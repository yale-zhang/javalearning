package java8.base.collect;

import org.junit.Test;
import stream.IStudent;

public class staticTest {
    //java8 允许使用static来修饰方法。静态方法只能通过接口名来调用
    @Test
    public void test1(){
        IStudent.sayHello();
    }
}
