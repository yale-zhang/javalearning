package design_pattern.callback;

public class tony implements Student {
    @Override
    public void resolveQuestion(Callback Callback) {
        // 模拟解决问题
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        Callback.tellAnswer(3);
    }
}
