package DesignPattern.Proxy.DynamicProxy;

import DesignPattern.Proxy.DynamicProxy.Service.DynamicProxyService;
import DesignPattern.Proxy.DynamicProxy.Service.DynamicProxyServiceImpl;

/**
 * @author 伍六七
 * @date 2023/4/4 14:53
 */
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        DynamicProxyService poxy = new JdkDynamicProxy(new DynamicProxyServiceImpl()).getPoxy();
        poxy.test();
    }
}
