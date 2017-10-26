package constructor;
/**
 * @Author: zhangsy
 * @Decription:
 * @Date: 10:11 2017/10/14
 */

public class SonClass extends FatherClass {
/**
 * 构造方法调用问题
 * 子类构造方法会首先默认调用父类的无参构造方法，无论是否显式写了super();
 */
    private static int countSon;
    static {
        System.out.println("子类可以访问父类的静态属性count " + count);
        System.out.println("子类的静态属性countSon初始化:" + countSon);
    }

    public SonClass(){
        System.out.println("执行了子类的无参构造方法");
    }

    public SonClass(String name){
        super(name);
        System.out.println("执行了子类的构造方法SonClass(String name) " + name);
    }

    public static void main(String[] args) {
        new SonClass("aaa");
       // new SonClass();
    }
}
