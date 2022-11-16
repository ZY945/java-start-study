package study.movie;
import java.util.ArrayList;

/**
 * @author 伍六七
 * @date 2022/9/19 18:27
 */

/**
 * 定义电影类（名称，分值，演员），创建三个电影对象，代表三部电影，存入集合并遍历。
 * 《阿甘正传》，9.7，汤姆.汉克
 * 《霸王别姬》，9.6，张国荣
 * 《肖申克的救赎》，9.7，蒂姆.罗宾斯
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Movie> list=new ArrayList();

        Movie m1=new Movie("阿甘正传",9.7,"汤姆.汉克");
        Movie m2=new Movie("霸王别姬",9.6,"张国荣");
        Movie m3=new Movie("肖申克的救赎",9.7,"蒂姆.罗宾斯");

        list.add(m1);
        list.add(m2);
        list.add(m3);

        for (int i = 0; i < list.size(); i++) {
            Movie movie= list.get(i);

            System.out.println("片名："+movie.getName());
            System.out.println("主演："+movie.getActor());
            System.out.println("评分："+movie.getScore());
        }

    }
}