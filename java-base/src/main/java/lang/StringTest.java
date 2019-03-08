package lang;

public class StringTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("130227");
        StringBuffer replace = str.replace(4, 7, "00");
        StringBuffer str1 = new StringBuffer("130227");
        StringBuffer replace1 = str1.replace(2, 7, "0000");
        System.out.print(replace+"  "+replace1);
    }
}
