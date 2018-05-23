package aviator.function;

import com.aisino.qysds.common.util.StringUtil;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

public class AviatorYearFunction extends AbstractFunction {
	@Override
	public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
		try {				
			String str = FunctionUtils.getStringValue(arg1, env);
			String _year="1900";//默认年份
			if(StringUtil.isNotEmpty(str) && str.length()>=4)
			{
				_year = str.substring(0, 4);
			}
			return new AviatorLong(Long.valueOf(_year));
		} catch (Exception e) {
			return new AviatorLong(1900);
		}
	}

	public String getName() {
		return "YEAR";
	}
}