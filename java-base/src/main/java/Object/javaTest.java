package Object;

import java.util.*;

public class javaTest {
    public static void main(String[] args) {
        String str = "18,11,8,7,13,12,4,2";
        String obj = "18,2";
        System.out.println(str.contains(obj));

        String[] departments = str.split(",");
		List<String> deptIdList = Arrays.asList(departments);
        Set<String> UserDepartmentList = new HashSet<String>(Arrays.asList(departments));
        System.out.println(UserDepartmentList.contains(obj));

        String[] departments1 = str.split(",");
        Set<String> UserDepartmentList1 = new HashSet<String>(Arrays.asList(departments1));
        String[] departments2 = obj.split(",");
        Set<String> UserDepartmentList2 = new HashSet<String>(Arrays.asList(departments2));
        System.out.println(UserDepartmentList1.contains(UserDepartmentList2));
        System.out.println(isContains(UserDepartmentList1,UserDepartmentList2));
    }

    static Boolean isContains(Set<String> s1,Set<String> s2){
        Boolean flag = false;
        for(String s:s2){
            if(s1.contains(s)){
                flag = true;
            }
        }
        return flag;
    }
}
