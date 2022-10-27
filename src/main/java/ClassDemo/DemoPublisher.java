package ClassDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author:ljh
 * @date:2022/3/23 14:55
 */

@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String message){
        //发布事件
        applicationContext.publishEvent(new EvenDemo(this, message));
    }

}