package DesignPattern.Factory.simpleFactoryPattern;

/**
 * @author 张洋
 * @description 通过反射获取对象实例,降低耦合
 * @date 2023-10-15 22:47
 */
public class SimpleFactoryPattern2 {
    public static void main(String[] args) {
        Bean server = BeanFactory.getBean(Server.class);
        server.print();
        Bean controller = BeanFactory.getBean(Controller.class);
        controller.print();
    }
}

/**
 * 这里没有设置单例,可以通过设置一个map容器来实现,getOrDefault
 */
class BeanFactory {
    public static Bean getBean(Class<? extends Bean> beanClass) {
        try {
            return beanClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}


/**
 * 抽象方法,子类必须重写
 */
abstract class Bean {
    public abstract void print();
}

class Server extends Bean {

    @Override
    public void print() {
        System.out.println("Server");
    }
}

class Controller extends Bean {

    @Override
    public void print() {
        System.out.println("Controller");
    }
}