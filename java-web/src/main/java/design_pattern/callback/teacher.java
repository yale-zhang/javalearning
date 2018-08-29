package design_pattern.callback;

public class teacher implements Callback {
    private Student student;

    public teacher(Student student){
        this.student = student;
    }

    public void askQuestion(){
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }

}
