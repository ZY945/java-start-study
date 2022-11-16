package collection.collection_s.list_s.vector_s;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 伍六七
 * @date 2022/8/12 21:31
 */
public class vector_demo {
    public static void main(String[] args) {
        //创建集合
        Vector vector = new Vector<>();


        //增加、删除、判断同上
        vector.add(1);
        vector.add(1);
        vector.add(2);
        vector.add("s");
        vector.add("l");//[1, 1, 2, s, l]
        vector.remove(4);//[1, 1, 2, s]
        vector.contains("s");//true
        vector.isEmpty();//false
        vector.indexOf("s");//3


        //遍历中枚举器遍历
        Enumeration en = vector.elements();
        while (en.hasMoreElements()){
            Object o = en.nextElement();
            System.out.printf(o+" ");//1 1 2 s
        }
    }
}
