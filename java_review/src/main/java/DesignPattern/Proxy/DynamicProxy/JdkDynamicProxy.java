package DesignPattern.Proxy.DynamicProxy;

import DesignPattern.Proxy.DynamicProxy.Annoation.RunTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 伍六七
 * @date 2023/4/4 14:33
 */
public class JdkDynamicProxy implements InvocationHandler {

    /**
     * 代理的对象
     */
    private Object target;
    public JdkDynamicProxy(Object target){
        this.target=target;
    }

    public <T> T getPoxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取真实方法
        Class<?> c = target.getClass();
        Method m;
        if(args == null){
            m = c.getMethod(method.getName());
        }else{
            Class[] methodArgs = new Class[args.length];
            for (int i = 0; i < methodArgs.length; i++) {
                methodArgs[i] = args[i].getClass();
            }
            m = c.getMethod(method.getName(),methodArgs);
        }
        RunTime annotation = m.getAnnotation(RunTime.class);
        //如果方法上有RunTime注解 计算方法运行时间
        if(annotation != null){
            long start = System.currentTimeMillis();
            Object result = method.invoke(target, args);
            long end = System.currentTimeMillis();
            System.out.println("动态代理"+"方法:"+method.getName()+",运行时间:"+(end-start)+"毫秒");
            return result;
        }

        return method.invoke(target, args);
    }
}
