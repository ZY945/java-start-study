package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 伍六七
 * @date 2023/8/25 15:29
 */
public class ReflectUtil {

    /**
     * 反射获取类
     *
     * @param className 类名
     * @return 类
     */
    public static Class<?> getClass(String className) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 反射获取指定方法
     *
     * @param clazz   类
     * @return 方法
     */
    public static Method[] getAllMethod(Class<?> clazz) {
        Method[] method = null;
        method = clazz.getMethods();
        return method;
    }

    /**
     * 反射获取指定方法
     *
     * @param clazz   类
     * @param methodName 方法名
     * @param parameterTypes 参数类型
     * @return 方法
     */
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Method method = null;
        try {
            method = clazz.getMethod(methodName, parameterTypes);
            method.setAccessible(true);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    /**
     * 获取成员变量
     *
     * @param clazz 类
     * @param fieldName 成员变量名
     * @return 成员变量
     */
    public static Object getField(Class<?> clazz, String fieldName) {
        Object field = null;
        try {
            field = clazz.getField(fieldName);
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }
}
