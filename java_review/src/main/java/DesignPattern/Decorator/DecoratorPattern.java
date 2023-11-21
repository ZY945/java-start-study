package DesignPattern.Decorator;

import java.io.IOException;

/**
 * @author 张洋
 * @description 装饰器模式--继承原有类,然后拓展方法-(可用于升级版本)<br>
 * jdk源码使用--输入输出流--
 * FilterInputStream继承InputStream,然后封装一个InputStream对象<br>
 * 然后BufferedInputStream继承FilterInputStream拓展实现缓冲的方法,
 * @date 2023-10-16 14:0
 */
public class DecoratorPattern {
    public static void main(String[] args) throws IOException {
    }
}

interface InputStream {
    void read();
}

class InputStreamV1 implements InputStream{

    @Override
    public void read() {
        System.out.println("读取成功");
    }
}

class InputStreamV2 implements InputStream{

    private InputStreamV1 v1;
    @Override
    public void read() {
        v1.read();
    }

    public void notice(){
        v1.read();
        System.out.println("已发送邮件通知");
    }
}