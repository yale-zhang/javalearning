#### Spring中的类型转换与校验  

1.[PropertyEditorSupport的使用](src/main/java/springframework/propertyeditorsupport)  
 Spring 在装配Bean 时可以使用字符串装配其他数据类型，如URL。也就是说Spring 会自动的将String 类型转换成URL类型进行Bean 的属性装配。这是通过JavaBean API 实现的（java.beans
 .PropertyEditor 接口）。  
    1.1 那么如何通过Spring 配置将String 类型转换成自定义的类型呢?  
     - 写一个编辑器类该类继承java.beans.PropertyEditorSupport 类来实现自己的编辑器类  
     - 在spring容器中对这个编辑器进行注册
     
     - PropertyEditorManager  
     - Introspector
     
2.CustomEditorConfigurer类用于实现在Spring 中注册自己定义的编辑器
  它是Spring 当中一个非常有用的工厂后处理类（工厂后处理通过Spring 的BeanFactoryPostProcessor 接口实现， 它是在Spring 容器启动并初始化之后进行对Spring 容器的操作类）。  
   1.1 如何配置CustomEditorConfigurer 类?  
   CustomEditorConfigurer 类中有一个customEditor属性，它是一个Map 类型。通过配置它便实现了自定义的编辑器注册。这个Map
    的键值对对应着转换类型和编辑器（转换类型是Key，编辑器是Value）。
   在Spring框架中，提供了几个内置的属性编辑器，如FileEditor,ResourceEditor等。要想使用自定义属性编辑器，需要经过两个步骤。  
   
   在Spring框架中，提供了几个内置的属性编辑器，如FileEditor,ResourceEditor等。要想使用自定义属性编辑器，需要经过两个步骤。
   
   - 定义一个自定义编辑器，可实现PropertyEditor接口或直接继承PropertyEditorSupport类  
   ```java
    public class PhotoEditor extends PropertyEditorSupport {  
        private PhotoService photoService;  
        @Override  
        public String getAsText() {  
            Photo photo = (Photo) getValue();  
            return photo.getGuid();  
        }  
        @Override  
        public void setAsText(String text) throws IllegalArgumentException {  
            Photo photo = photoService.loadPhotoByGuid(text);  
            setValue(photo);  
        }  
    }  
   ```
   - 注册自定义编辑器
   Spring提供了一个PropertyEditorRegistry接口和PropertyEditorRegistrySupport类来自定义一个注册器。其中PropertyEditorRegistrySupport是Spring
   提供的一个默认实现，里面注册了一些内置的编辑器。  
   可以在配置文件中注册自定义编辑器，也可以以编程的方式注册自定义编辑器。  
   ```java
     String location = "testApplicationContext.xml";  
             Resource resource = new ClassPathResource(location);  
             XmlBeanFactory beanFactory = new XmlBeanFactory(resource);  
             beanFactory.registerCustomEditor(Photo.class, PhotoEditor.class);     
   ```
   ```xml
     <bean id="customEditorConfigurer" class="org.springframework.beans.factory.config.CustomEditorConfigurer">  
             <property name="customEditors">  
                 <map>  
                     <entry key="com.dream.model.photo.Photo">  
                         <ref bean="photoEditor"/>  
                     </entry>  
                 </map>  
             </property>  
         </bean>  
         <bean id="photoEditor" class="com.dream.editor.PhotoEditor">  
             <property name="photoService" ref="photoService"/>  
         </bean> 
   ```
       