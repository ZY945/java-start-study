package DesignPattern.Proxy.StaticProxy;

import DesignPattern.Proxy.StaticProxy.Service.Service;

/**
 * 原方法 ;
 * <p >静态代理,在类内对方法前后进行操作,类似简单的装饰模式</p>
 * <pre> {@code
 *public interface DynamicProxyService {
 *     public int add(int a, int b);
 *     public static class DynamicProxyDynamicProxyServiceImpl implements DynamicProxyService{
 *
 *         @Override
 *         public int add(int a, int b) {
 *             return a+b;
 *         }
 *     }
 *     //静态代理
 *     public static class ServiceStaticProxy implements DynamicProxyService {
 *
 *         public DynamicProxyService service;
 *
 *         public ServiceStaticProxy(DynamicProxyService service) {
 *             this.service = service;
 *         }
 *
 *         @Override
 *         public int add(int a, int b) {
 *             long start = System.currentTimeMillis();
 *             int result = service.add(a, b);
 *             long end = System.currentTimeMillis();
 *             System.out.println("方法add消耗时间:"+(end-start)+"毫秒");
 *             return result;
 *         }
 *     }
 *
 * }}</pre>
 * @author 伍六七
 * @date 2023/4/4 13:50;
 */
public class ServiceStaticProxy implements Service {

    public Service service;

    public ServiceStaticProxy(Service service) {
        this.service = service;
    }

    @Override
    public int test() {
        long start = System.currentTimeMillis();
        int result = service.test();
        long end = System.currentTimeMillis();
        System.out.println("静态代理"+"方法test消耗时间:"+(end-start)+"毫秒");
        return result;
    }
}
