package DesignPattern.Observer;

import Converter.ByteConverter;
import encipherUtil.Base64Util;
import encipherUtil.reversible.symmetrical.AESEncipher;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Observable;
import java.util.Observer;

/**
 * @author 张洋
 * @description 观察者模式 <br>
 * jdk源码使用--Observer和 Observable
 * @date 2023-10-16 14:58
 */
public class ObserverPattern {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ExamNotice notice = new ExamNotice("明天考试");
        Student s1 = new Student("小明");
        Student s2 = new Student("小王");
        Student s3 = new Student("小张");

        notice.addObserver(s1);
        notice.addObserver(s2);
        notice.addObserver(s3);

        System.out.println("目前最新通知"+notice);
        notice.setMsg("明天不考试了,要放假了");
        System.out.println("目前最新通知"+notice);
    }
}


/**
 * 被观察的对象
 */
class ExamNotice extends Observable {
    private String msg;
    ExamNotice(String msg){
        this.msg=msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public void setMsg(String msg){
        super.setChanged();//设置变化点
        super.notifyObservers(msg);
        this.msg=msg;
    }
    public String toString(){
        return "通知为:"+this.msg;
    }
}
// 观察者
class Student implements Observer{
    private String name;

    Student(String name){
        this.name=name;
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ExamNotice && arg instanceof String){
            System.out.println(this.name+"收到通知为:"+arg);
        }
    }
}