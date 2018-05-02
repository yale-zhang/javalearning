package Object;

import java.util.Objects;

public class Option {
    public String Object(String pram){
       return Objects.requireNonNull(pram);
    }

    public static void main(String[] args){
        try {
            String pram =null;
            Objects.requireNonNull(pram,"pram不能为null");
            if (pram == null){
                throw new NullPointerException(pram+"不能为null");
            }
            System.err.print(pram);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
