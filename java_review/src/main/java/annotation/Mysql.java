package annotation;

public class Mysql {
    @AccessLimit(seconds = 10,maxLimit = 5,msg = "mysql连接限制,3秒内最多五次")
    public void connect() {
        System.out.println("mysql连接");
    }
}
