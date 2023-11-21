package DesignPattern.Singleton;

/**
 * 单例饿汉
 * @author 伍六七
 * @date 2023/3/6 9:53
 */
public class SingletonHungryPattern {
    public static void main(String[] args) {
        SingletonHungry singleton1 = SingletonHungry.getSingleton();
        SingletonHungry singleton2 = SingletonHungry.getSingleton();
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
class SingletonHungry{
    private static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){}

    public static SingletonHungry getSingleton() {
        return singletonHungry;
    }
}
