package annotation.Interceptor;

import annotation.Mysql;
import annotation.redis.RedisUtil;

public class CGLibDynamicProxy {
    public static void main(String[] args) {
        new Thread(RedisUtil::run).start();
        for (int i = 0; i < 5; i++) {
            //模拟请求调用
            new Thread(() -> {
                CGLibProxy<Mysql> cgLibProxy = new CGLibProxy<>();
                Mysql mysql = cgLibProxy.getInstance(new Mysql());
                while (true) {
                    mysql.connect();
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, "http-thread-" + i).start();
        }
    }
}