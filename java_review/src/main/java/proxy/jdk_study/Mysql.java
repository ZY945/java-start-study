package proxy.jdk_study;

public class Mysql implements DB{
    @Override
    public void connect() {
        System.out.println("mysql连接");
    }
}
