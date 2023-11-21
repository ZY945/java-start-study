package DesignPattern.Proxy.DynamicProxy.Annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 伍六七
 * @date 2023/4/4 14:32
 */
@Target(ElementType.METHOD)//只能在方法上使用
@Retention(RetentionPolicy.RUNTIME)//运行时可以获取
public @interface RunTime {
}
