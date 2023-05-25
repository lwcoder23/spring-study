package aop.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        /*
        * Proxy.newProxyInstance() 方法，返回动态代理类对象
        *
        * @param: ClassLoader
        * @param: Class[] interface 目标对象实现的所有接口的 class类型数组
        * @param: InvocationHandler 设置代理对象实现目标对象方法的过程
        * */

        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        // param3 is a interface, so just implements this interface, no-name inner class
        InvocationHandler invocationHandler = new InvocationHandler() {
            /*
            * param: proxy 代理对象
            * param: method 需要重写目标对象的方法
            * param: args method方法的参数
            * */
            // 重写 InvocationHandler 中的方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = null;

                try {
                    System.out.println("[动态代理][日志] "+method.getName()+"，参 数："+ Arrays.toString(args));
                            result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] "+method.getName()+"，结 果："+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] "+method.getName()+"，异 常："+e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] "+method.getName()+"，方法 执行完毕");
                }

                return result;
            }

        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

    }
}
