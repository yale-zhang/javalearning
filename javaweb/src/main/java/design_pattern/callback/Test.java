package design_pattern.callback;

public class Test {
    public static void main(String[] args) {
        teacher teacher = new teacher(new tony());
        teacher.askQuestion();
    }
}
