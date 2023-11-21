package DesignPattern.Proxy.StaticProxy.Service;

import DesignPattern.Proxy.DynamicProxy.Annoation.RunTime;

import java.util.concurrent.Callable;

/**
 * @author 伍六七
 * @date 2023/4/4 13:48
 */
public class ServiceImpl implements Service {
    Integer finalRes = 0;
    @Override
    public int test() {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100000000; i++) {
                    //进行100000次的循环
                    finalRes++;
                }
                return finalRes;
            }
        };
        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100000000; i++) {
                    //进行100000次的循环
                    finalRes++;
                }
                return finalRes;
            }
        };
        try {
            callable.call();
            callable1.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalRes;
    }
}
