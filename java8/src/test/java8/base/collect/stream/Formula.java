package java8.base.collect.stream;

/**
 * Formula表示一个设计 计算公式 的接口
 */
public interface Formula {
    //计算
    double calculate(int a);
    //开方
    //Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
    default double sqrt(int a){
        return Math.sqrt(a);
    }
    //现在接口还可以存在静态方法，可以使用 接口名.静态方法名 的形式直接调用
    static int add(int a,int b){
       return a+b;
    };
}
