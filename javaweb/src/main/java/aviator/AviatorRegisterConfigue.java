package aviator;

import aviator.function.AviatorAbsoluteFunction;
import com.googlecode.aviator.AviatorEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("aviatorRegisterConfigue")
public class AviatorRegisterConfigue implements ApplicationListener<ContextRefreshedEvent>{
    //ContextRefreshedEvent 为初始化完毕事件，spring还有很多事件可以利用
    //@Autowired
    //RedisClient redisClient;

    /**
     * Triggered when a applicationcontext been initialized or refresh
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
            //registered a custom funtion
            AviatorEvaluator.addFunction(new AviatorAbsoluteFunction());
            //LOG.info("Aviator自定义函数 注册成功");
        }

    }
}
