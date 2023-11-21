package annotation.Interceptor;

import annotation.AccessLimit;
import annotation.redis.RedisUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CGLibProxy<T> implements MethodInterceptor {

    private T target;

    public T getInstance(T target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        if (checkAccessLimitAnnotation()) {
            result = methodProxy.invoke(this.target, args);
            return result;
        }
        return result;
    }


    public boolean checkAccessLimitAnnotation(Method method) throws Exception {
        AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
        if (accessLimit == null) {
            return true;
        }
        int seconds = accessLimit.seconds();
        int maxCount = accessLimit.maxLimit();
        // 暂时用当前线程来表示唯一表示,开发中应该是ip+设备型号
        String redisKey = Thread.currentThread().getName();
        Integer redisResult = RedisUtil.get(redisKey);
        //如果是redis,value一般是string,这里转化一下
        if (redisResult == null) {
            System.out.println(redisKey + "访问了1次");
            RedisUtil.expired(redisKey, seconds, TimeUnit.SECONDS);
        } else {
            if (redisResult >= maxCount) {
                // 通过response返回相应
                System.out.println(redisKey + "限流了");
                return false;
            } else {
                redisResult++;
                System.out.println(redisKey + "访问了" + redisResult + "次");
                RedisUtil.increment(redisKey);
            }
        }
        return true;
    }

    /**
     * 代理后不要用intercept的object,那个貌似是代理后的类,用target
     *
     * @return
     * @throws Exception
     */
    public boolean checkAccessLimitAnnotation() throws Exception {
        Method[] methods = target.getClass().getMethods();
        for (Method method : methods) {
            AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                continue;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxLimit();
            // 暂时用当前线程来表示唯一表示,开发中应该是ip+设备型号
            String redisKey = Thread.currentThread().getName();
            Integer redisResult = RedisUtil.get(redisKey);
            //如果是redis,value一般是string,这里转化一下
            if (redisResult == null) {
                System.out.println(redisKey + "访问了1次");
                RedisUtil.expired(redisKey, seconds, TimeUnit.SECONDS);
            } else {
                if (redisResult >= maxCount) {
                    // 通过response返回相应
                    System.out.println(redisKey + "限流了");
                    return false;
                } else {
                    redisResult++;
                    System.out.println(redisKey + "访问了" + redisResult + "次");
                    RedisUtil.increment(redisKey);
                }
            }

        }

        return true;
    }
}