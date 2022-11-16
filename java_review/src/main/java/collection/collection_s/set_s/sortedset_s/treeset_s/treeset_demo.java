package collection.collection_s.set_s.sortedset_s.treeset_s;

import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author 伍六七
 * @date 2022/8/12 21:57
 * TreeSet
 * 特点
 * ● 基于排列顺序实现元素不重复
 * ● 实现SortedSet接口(如果实现该接口需要重写方法)，对集合元素自动排序
 * ● 元素对象的类型必须实现Comparable接口，指定排序规则，默认升序
 * ● 通过CompareTo方法确定是否为重复元素
 * 存储结构：红黑树
 */

public class treeset_demo  {

    public static void main(String[] args) {

        //创建集合
        TreeSet<String> treeSet = new TreeSet<>();

        //添加元素
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("1");//[1, 2, 3]
        System.out.println(treeSet);
        //删除元素
        treeSet.remove("1");//[2, 3]


        //遍历 1. 增强for 2. 迭代器

        //判断
        System.out.println(treeSet.contains("1"));//false
        System.out.println(treeSet.contains("1"));//false
    }
}
