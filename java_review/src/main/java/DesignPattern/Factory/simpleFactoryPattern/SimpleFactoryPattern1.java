package DesignPattern.Factory.simpleFactoryPattern;


/**
 * @author 张洋
 * @description 简单工厂--耦合度太高
 * @date 2023-10-15 21:48
 */
public class SimpleFactoryPattern1 {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.createComputer("HuaWeiComputer");
        computer.print();
        //jdk案例
//        Calendar instance = Calendar.getInstance();
    }
}

class ComputerFactory {
    public enum ComputerType{
        HuaWei,Dell;
    }
    public static Computer createComputer(String type) {
        Computer Computer = null;
        if (type != null) {
            switch (type) {
                case "DellComputer":
                    Computer = new DellComputer();
                    break;
                case "HuaWeiComputer":
                    Computer = new HuaWeiComputer();
                    break;
            }
        }
        return Computer;
    }
}


/**
 * 抽象方法,子类必须重写
 */
abstract class Computer {
    public abstract void print();
}

class DellComputer extends Computer {

    @Override
    public void print() {
        System.out.println("Dell");
    }
}

class HuaWeiComputer extends Computer {

    @Override
    public void print() {
        System.out.println("HuaWei");
    }
}