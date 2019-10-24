package springframework.propertyeditorsupport.Vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Person {

    private Integer id;
    private  String name;
    private int age;
    private Date birthday;
    private List<Integer> nums;
    private Boo boo;
    private Point point;
}
