package ClassDemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author:ljh
 * @date:2022/3/23 14:50
 */

@Component
public class ListenDemo implements ApplicationListener<EvenDemo> {

    @Override
    public void onApplicationEvent(EvenDemo event) {
        String message = event.getMessage();
        System.out.println("qaq"+message);



    }
}