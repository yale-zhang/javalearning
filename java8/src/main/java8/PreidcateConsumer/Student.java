package java8.PreidcateConsumer;

/**
 * @ClassName Student
 * @Description TODO
 * @Author yale
 * @Date 2018/12/20 14:21
 * @Version 1.0
 **/
public class Student {

    String firstName;
    String lastName;
    Double grade;
    Double feeDiscount = 0.0;
    Double baseFee = 20000.0;

    public Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public void printFee(){
        Double newFee = baseFee - ((baseFee * feeDiscount) / 100);
        System.out.println("The fee after discount: " + newFee);
    }

}
