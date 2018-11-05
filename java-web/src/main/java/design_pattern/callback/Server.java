package design_pattern.callback;

import com.googlecode.aviator.AviatorEvaluator;

public class Server {

   public void toEvaluator(CSCallBack csCallBack,String a,String b){
       String s = AviatorEvaluator.execute("" + a + "+" + b + "").toString();
       String status = null;
       if (s.equals("3")) {
            status = "200";
       }else {
            status = "500";
       }
       csCallBack.process(status);
   }
}
