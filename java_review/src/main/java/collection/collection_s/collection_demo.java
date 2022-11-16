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
        collection.add("2");
        collection.add("2");
        collection.add("1");
        collection.add("2");
        collection.add(1);
        System.out.println(collection);//[1, 1, 2]
        System.out.println(collection);


        //2删除元素
        //有1和"1"的区别，remove的是对象，而不是索引
        collection.remove("1");
        System.out.println(collection);//[1, 2]
//        collection.clear();//[]
        System.out.println(collection);


        //3遍历
        //增强遍历
        for(Object o : collection){
            System.out.println(o);
        }

        //迭代器
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("2")){
//                collection.remove(iterator.next());
                iterator.remove();

            }
        }
        Object a = 1;
        System.out.println(a.getClass().getTypeName());
        System.out.println(collection);

        //4判断
        System.out.println(collection.contains("1"));//true
        System.out.println(collection.isEmpty());//false
    }
}
