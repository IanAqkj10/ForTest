package sijimoshi.dongtaidaili;

import java.lang.reflect.Proxy;

/**
 * @Description: 代理工厂
 * @author:ljh
 * @date:2022/8/3 14:36
 */

public class JdkProxy {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DtDlHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }

}