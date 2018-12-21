package java8.functionalInterface;

/**
 * @ClassName
 * @Description 为自定义接口提供一个描叙性名称
 * @Author yale
 * @Date 2018/12/19 17:21
 * @Version 1.0
 **/
@FunctionalInterface
public interface Transformer<T> {
  T validate(T input);
}
