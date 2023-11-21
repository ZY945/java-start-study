package proxy.cglib_study;

import net.sf.cglib.core.DebuggingClassWriter;

public class CGLibDynamicProxy {
    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/larry/IdeaProjects/pkslow-samples/java-basic/jdk-cglib-proxy/target/cglib_proxy_classes");
        CGLibProxy<Mysql> cgLibProxy = new CGLibProxy<>();
        Mysql mysql = cgLibProxy.getInstance(new Mysql());
        mysql.connect();
    }
}