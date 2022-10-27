package sijimoshi.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: jdk动态代理类
 * @author:ljh
 * @date:2022/8/3 14:34
 */

public class DtDlHandler implements InvocationHandler {

    private final Object target;

    public DtDlHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}