package collection.collection_s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 伍六七
 * @date 2022/8/12 19:37
 */
public class collection_demo {
    public static void main(String[] args) {
        //0创建集合
        Collection collection = new ArrayList();
        System.out.println(collection);//[]


        //1添加元素
        collection.add("1");
        collection.add("1");
        collection.add("1");
        collection.add("2");
        System.out.println(collection);//[1, 1, 2]


        //2删除元素
        collection.remove("1");
        System.out.println(collection);//[1, 2]
        collection.clear();//[]
        System.out.println(collection);


        //3遍历
        //增强遍历
        for(Object o : collection){
            System.out.println(o);
        }

        //迭代器
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            String o = (String) iterator.next();
            System.out.println(o);
        }

        //4判断
        System.out.println(collection.contains("1"));//true
        System.out.println(collection.isEmpty());//false
    }
}
