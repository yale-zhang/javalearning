package regex;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class regexTest {

    public static void main(String[] args) {

        String jsgsCont="{C101020_15-15!right_sns#8}-{C101020_15-15!right_sns#9}";
        String jsgsCont1="{1511!bnjflj#0}>0||{1511!bndflj#1}>0||{1511!ncye}>0||{1511!qmye}>0";
        List<String> ls = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<=\\{)(.+?)(?=\\})");
        Matcher matcher = pattern.matcher(jsgsCont1);
        while (matcher.find()) {
            String s = matcher.group();
            ls.add(s);
        }
        //AviatorEvaluator.execute();
        for (String l:ls){
            System.out.print(l+"    ");
        }
    }

}
