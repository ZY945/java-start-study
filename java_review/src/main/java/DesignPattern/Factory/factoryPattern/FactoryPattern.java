package DesignPattern.Factory.factoryPattern;

import java.util.Scanner;

/**
 * @author 张洋
 * @description 工厂模式--简单工厂的变形
 * @date 2023-10-15 21:45
 */
public class FactoryPattern {
    public static void main(String[] args) {


    }
}

class ServerBeanFactory implements BeanFactory{

    @Override
    public Bean getBean() {
        return new Server();
    }
}
class ControllerBeanFactory implements BeanFactory{

    @Override
    public Bean getBean() {
        return new Controller();
    }
}


interface BeanFactory{
    Bean getBean();
}

abstract class Bean{
    public abstract void print();
}
class Server extends Bean{

    @Override
    public void print() {
        System.out.println("Server");
    }
}

class Controller extends Bean{

    @Override
    public void print() {
        System.out.println("Controller");
    }
}