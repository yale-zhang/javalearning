package aviator.function;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

import java.util.Map;

/**
 * 如果你的参数个数不确定，可以继承 AbstractVariadicFunction 类，只要实现其中的 variadicCall 方法即可
 */
public class GetFirstNonNullFunction extends AbstractVariadicFunction {
    @Override
    public AviatorObject variadicCall(Map<String, Object> env, AviatorObject... args) {
        if (args != null) {
            for (AviatorObject arg : args) {
                if (arg.getValue(env) != null) {
                    return arg;
                }
            }
        }
        return new AviatorString(null);
    }

    @Override
    public String getName() {
        return "getFirstNonNull";
    }
}
