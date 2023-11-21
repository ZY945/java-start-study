package proxy.jdk_study;

import java.lang.reflect.Proxy;

public class JDKProxyMain {
    public static void main(String[] args) {
        //1.普通调用
//        DB mysql = new Mysql();
//        mysql.connect();

        //2.使用jdk代理
        ClassLoader classLoader = JDKProxyMain.class.getClassLoader();
        Class<?>[] interfaces = Mysql.class.getInterfaces();
        Mysql mysql = new Mysql();
        DB db = (DB)Proxy.newProxyInstance(classLoader, interfaces, new DBInvocation(mysql));
        db.connect();
    }
}
