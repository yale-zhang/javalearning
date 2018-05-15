package design_pattern.callback;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    public static void main(String[] args) {
        teacher teacher = new teacher(new tony());
        teacher.askQuestion();
    }
}
