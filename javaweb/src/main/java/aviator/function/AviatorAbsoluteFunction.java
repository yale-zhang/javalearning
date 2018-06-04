package aviator.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorNumber;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

public class AviatorAbsoluteFunction  extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {

        Number left = FunctionUtils.getNumberValue(arg1, env);

        if (left.doubleValue() < 0)
            left = 0 - left.doubleValue();

        AviatorNumber db =new AviatorDouble( left.doubleValue());

        return db;
    }

    public String getName() {
        return "ABSOLUTE";
    }
}
