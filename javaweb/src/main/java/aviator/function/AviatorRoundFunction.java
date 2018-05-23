package aviator.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

public class AviatorRoundFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
    	
    	Number left = FunctionUtils.getNumberValue(arg1, env);        
    	int ws = FunctionUtils.getNumberValue(arg2, env).intValue();
    	
    	BigDecimal bd = BigDecimal.valueOf(left.doubleValue());    	
    	
    	left =bd.setScale(ws,BigDecimal.ROUND_HALF_UP).doubleValue();    	  
        
        return new AviatorDouble(left);
    }
    public String getName() {
        return "ROUND";
    }
}