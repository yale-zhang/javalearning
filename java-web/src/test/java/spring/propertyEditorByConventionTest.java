package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springframework.propertyeditorsupport.Circle;

public class propertyEditorByConventionTest {

    /**
     * 通过约定机制来自动查询PropertyEditor完成类型转换
     */
    @Test
    public void testPropertyEditorByConvention(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("prop-editor-app-context.xml");
        Circle circle  = ctx.getBean("circle", Circle.class);
        System.out.println("foo.x: "+circle.getPoint().getX()+",foo.y: "+circle.getPoint().getY());
    }
}
