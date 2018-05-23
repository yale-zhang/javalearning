package aviator.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

public class AviatorMaxFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
    	
    	Number left = FunctionUtils.getNumberValue(arg1, env);        
    	Number right = FunctionUtils.getNumberValue(arg2, env);
    	 
    	Number newV = left.doubleValue() < right.doubleValue() ? right:left;
        
        return new AviatorDouble(newV.doubleValue());
    }
    public String getName() {
        return "MAX";
    }
}
