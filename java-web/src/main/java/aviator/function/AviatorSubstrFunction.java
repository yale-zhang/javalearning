package aviator.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class AviatorSubstrFunction extends AbstractFunction {
	@Override
	public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
		try {				
			String str = FunctionUtils.getStringValue(arg1, env);
			long len=0;
			 len = ((AviatorLong) arg2).longValue();

			String restr="";//默认年份
			if(StringUtils.isNotEmpty(str) && len>0)
			{
				restr = str.substring(0, (int)len);
			}
			return new AviatorString(restr);
		} catch (Exception e) {
			return new AviatorString("");
		}
	}

	public String getName() {
		return "SUBSTR";
	}
}