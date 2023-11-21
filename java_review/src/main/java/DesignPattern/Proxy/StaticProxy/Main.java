package DesignPattern.Proxy.StaticProxy;

import DesignPattern.Proxy.DynamicProxy.JdkDynamicProxy;
import DesignPattern.Proxy.DynamicProxy.Service.DynamicProxyService;
import DesignPattern.Proxy.DynamicProxy.Service.DynamicProxyServiceImpl;
import DesignPattern.Proxy.StaticProxy.Service.Service;
import DesignPattern.Proxy.StaticProxy.Service.ServiceImpl;
import DesignPattern.Proxy.StaticProxy.ServiceStaticProxy;

/**
 * @author 伍六七
 * @date 2023/4/4 14:05
 */
public class Main {
    public static void main(String[] args) {
        ServiceStaticProxy serviceStaticProxy = new ServiceStaticProxy(new ServiceImpl());
        serviceStaticProxy.test();
    }
}
