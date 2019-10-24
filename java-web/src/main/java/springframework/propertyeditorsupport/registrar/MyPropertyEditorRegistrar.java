package springframework.propertyeditorsupport.registrar;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import springframework.propertyeditorsupport.Vo.Point;
import springframework.propertyeditorsupport.PointEditor;

/**
 *  PropertyEditorRegistrar
 *  PropertyEditorRegistrar的作用是将用户自定义的PropertyEditor注册到PropertyEditorRegistry中
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {
    /**
     * 定义一个PropertyEditorRegistrar来完成PropertyEditor的注册功能
     * @param registry
     */
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        //将自己所定义的PropertyEditor注册到PropertyEditorRegistry中
        registry.registerCustomEditor(Point.class,"point",new PointEditor());
    }
}
