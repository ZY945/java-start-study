package reflect.test;

import reflect.ReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 伍六七
 * @date 2023/8/25 15:37
 */
public class TestDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("---------------------");
        //获取public修饰的方法
        Method[] allMethod = ReflectUtil.getAllMethod(Demo.class);
        for (Method method : allMethod) {
            System.out.println(method);
        }
        System.out.println("---------------------");
        Class<?> aClass = ReflectUtil.getClass("reflect.test.Demo");
        System.out.println(aClass);
        System.out.println("---------------------");
        Method method = ReflectUtil.getMethod(Demo.class, "get");
        System.out.println(method);
        System.out.println("---------------------");
        Method method2 = ReflectUtil.getMethod(Demo.class, "post", int.class);
        Class<?> aClass1 = ReflectUtil.getClass("reflect.test.Demo");
        Demo o = (Demo) aClass1.getConstructors()[0].newInstance();
        method2.invoke(o,1);
        System.out.println(method2);
        long l = System.nanoTime();
        System.out.println(l);
        System.out.println("---------------------");
    }
}
