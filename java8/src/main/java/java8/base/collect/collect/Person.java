package java8.base.collect.collect;

/**
 * @ClassName Person
 * @Description TODO
 * @Author yale
 * @Date 2019/1/9 17:53
 * @Version 1.0
 **/
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
