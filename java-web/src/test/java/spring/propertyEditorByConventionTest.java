package spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springframework.propertyeditorsupport.PointEditor;
import springframework.propertyeditorsupport.Vo.Circle;
import springframework.propertyeditorsupport.Vo.DateBean;
import springframework.propertyeditorsupport.Vo.Person;
import springframework.propertyeditorsupport.Vo.Point;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class propertyEditorByConventionTest {

    /**
     * 通过约定机制来自动查询PropertyEditor完成类型转换
     */
    @Test
    public void testPropertyEditorByConvention(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("prop-editor-app-context.xml");
        Circle circle  = ctx.getBean("circle", Circle.class);
        //System.out.println("foo.x: "+circle.getPoint().getX()+",foo.y: "+circle.getPoint().getY());
        Assert.assertEquals(1,circle.getPoint().getX());
        Assert.assertEquals(2,circle.getPoint().getY());
    }

    /**
     * 使用BeanWrapperImpl设置基本属性
     */
    @Test
    public void testSetBasicPropertyValue(){
        Person person = new Person();
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(person);
        beanWrapper.setPropertyValue("id",1);
        Assert.assertEquals(1,person.getId().intValue());

        //设置BeanWrapper自动创建内联属性，否则会引发NullValueInNestedPathException
        beanWrapper.setAutoGrowNestedPaths(true);
        beanWrapper.setPropertyValue("nums[0]", "123");
        beanWrapper.setPropertyValue("nums[1]", "456");
        System.out.println(person.getNums());

        beanWrapper.setPropertyValue("boo.foo.x", "1");
        System.out.println(person.getBoo().getFoo().getX());

        //注册自定义的PropertyEditor到BeanWrapper中
        beanWrapper.registerCustomEditor(Point.class,new PointEditor());

        //BeanWrapper通过注册的PropertyEditor完成数据类型的转换
        beanWrapper.setPropertyValue("point","1;2");
    }

    @Test
    public void test() {
        BeanFactory context = new ClassPathXmlApplicationContext(
                "prop-converter-app-context.xml");
        DateBean dateBean = (DateBean) context.getBean("dateBean");
        assertNotNull(dateBean);
        assertNotNull(dateBean.getDate());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df.format(dateBean.getDate());
        assertEquals("2014-03-04 09:21:20", dateStr);
    }
}
