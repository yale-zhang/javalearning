package java8.PreidcateConsumer;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ClassName PreidcateConsumerDemo
 * @Description TODO
 * @Author yale
 * @Date 2018/12/20 14:20
 * @Version 1.0
 **/
public class PreidcateConsumerDemo {

    //Predicate和Consumer接口的test()和accept()方法都接受一个泛型参数。
    //不同的是test()方法进行某些逻辑判断并返回一个boolean值，而accept()接受并改变某个对象的内部值。
    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer){
        //Use the predicate to decide when to update the discount.
        if (predicate.test(student)){
            //Use the consumer to update the discount value.
            consumer.accept(student);
        }
        return student;
    }

    public static void main(String[] args) {
        //使用Predicate接口实现类的test()方法判断输入的Student对象是否拥有费用打折的资格，
        // 然后使用Consumer接口的实现类更新输入的Student对象的折扣
        Student student1 = new Student("Ashok","Kumar", 9.5);

        student1 = updateStudentFee(student1,
                //Lambda expression for Predicate interface
                student -> student.grade > 8.5,
                //Lambda expression for Consumer inerface
                student -> student.feeDiscount = 30.0);
        student1.printFee();

        Student student2 = new Student("Rajat","Verma", 8.0);
        student2 = updateStudentFee(student2,
                student -> student.grade >= 8,
                student -> student.feeDiscount = 20.0);
        student2.printFee();

        //Consumer
        Consumer<Integer> consumer = (x) -> {
            int num = x * 2;
            System.out.println(num);
        };
        Consumer<Integer> consumer1 = (x) -> {
            int num = x * 3;
            System.out.println(num);
        };
        //accept方法  该函数式接口的唯一的抽象方法,接收一个参数,没有返回值.
        //andThen方法  在执行完调用者方法后再执行传入参数的方法.
        consumer.accept(10);
        consumer.andThen(consumer1).accept(10);

    }
}
