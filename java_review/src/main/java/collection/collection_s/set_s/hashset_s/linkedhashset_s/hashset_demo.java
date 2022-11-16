package collection.collection_s.set_s.hashset_s.linkedhashset_s;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 伍六七
 * @date 2022/8/12 21:49
 * HashSet
 * 特点
 * 存储结构：哈希表（数组+链表+红黑树）
 * 存储过程（重复依据）
 * 1. 根据hashCode计算保存的位置，如果位置为空，直接保存，若不为空，进行第二步
 * 2. 再执行equals方法，如果equals为true，则认为是重复，否则形成链表
 */
public class hashset_demo {
    public static void main(String[] args) {
        //新建集合
        HashSet<String> hashSet = new HashSet<String>();


        //添加元素
        hashSet.add("1");
        hashSet.add("1");
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        System.out.println(hashSet);//[1, 2, 3]

        //删除元素
        hashSet.remove("1");
        System.out.println(hashSet);//[2, 3]


        //遍历操作
        //1. 增强for
        for(String set:hashSet){
            System.out.print(set);//23
        }

        //2. 迭代器
        Iterator<String> it = hashSet.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.printf(s+" ");//2 3
        }


        //判断
        System.out.println(hashSet.contains("2"));//true

        System.out.println(hashSet.isEmpty());//false
    }
}
