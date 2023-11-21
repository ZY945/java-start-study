package proxy.jdk_study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DBInvocation implements InvocationHandler {
    private final DB target;

    public DBInvocation(DB target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        System.out.println(target + ": ===JDK proxy===");
        Object result = method.invoke(this.target, args);
        System.out.println(target + ": ===JDK proxy===");
        long end = System.nanoTime();
        System.out.println("Executing time: " + (end - start) + " ns");
        return result;
    }
}
