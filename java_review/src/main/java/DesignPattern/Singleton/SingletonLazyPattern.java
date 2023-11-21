package DesignPattern.Singleton;

/**
 * 单例懒汉式
 * 双重校验+加锁
 * @author 伍六七
 * @date 2023/3/6 9:38
 */
public class SingletonLazyPattern {
    public static void main(String[] args) {
        SingletonLazy singleton1 = SingletonLazy.getInstance();
        SingletonLazy singleton2 = SingletonLazy.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}

class SingletonLazy{
    private static volatile SingletonLazy singletonLazy = null;
    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(singletonLazy==null){
            synchronized (SingletonLazy.class){
                if(singletonLazy==null){
                    singletonLazy=new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

}
