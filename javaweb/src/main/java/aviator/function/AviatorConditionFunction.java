package aviator.function;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Map;

/**
作用: 解决原有的三元运算符的bug
*
*/
public class AviatorConditionFunction extends AbstractFunction {

	@Override
	public AviatorObject call(Map<String, Object> env, AviatorObject cod1, AviatorObject exp1, AviatorObject exp2) {
		Double db = 0.0;
		BigDecimal bd=null;
		try {

			String _condition = FunctionUtils.getStringValue(cod1, env);// 三元表达式
																		// ,条件
			String _expressioin1 = FunctionUtils.getStringValue(exp1, env);// 三元表达式
																			// ,条件结果为true时执行
			String _expressioin2 = FunctionUtils.getStringValue(exp2, env);// 三元表达式
																			// ,条件为false时执行
			Expression compiledExp = AviatorEvaluator.compile(_condition);
		   // 执行表达式
			Boolean result = (Boolean) compiledExp.execute(env);
			String expression = result ? _expressioin1 : _expressioin2;
			compiledExp = AviatorEvaluator.compile(expression);
			String res = compiledExp.execute(env).toString();
			if(StringUtils.isNotEmpty(res)&& StringUtils.isNumeric(res)) {
				db = Double.valueOf(res);
				return  new AviatorDouble(db);
			}
			else
			{
				return new AviatorString(res);
			}

		} catch (Exception e) {
			
		}
		return new AviatorString("");
	}
	  
	  
	@Override
	public String getName() { 
		return "CONDITION";
	}

}
