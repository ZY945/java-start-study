package collection.collection_s;

import java.util.*;

/**
 * @author 伍六七
 * @date 2022/8/13 18:24
 */
public class collections_tool {
    public static void main(String[] args) {
        ArrayList collection = new ArrayList();
        collection.add(4);
        collection.add(2);
        collection.add(3);
        collection.add(1);
        ArrayList collection2 = new ArrayList();
        collection2.add(5);
        collection2.add(5);
        collection2.add(5);
        collection2.add(5);
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        list2.add(2);
        list2.add(2);
        list.addAll(collection);


        //将指定元素添加到指定集合
        Collections.addAll(collection,1,2,3,4);
        System.out.println(collection);

        //最大-比较器可以作为第二个参数决定规则
        System.out.println(Collections.max(collection));

        //最小-比较器可以作为第二个参数决定规则
        System.out.println(Collections.min(collection));

        //排序
        Collections.sort(list);
        System.out.println("list"+list);

        //交互指定位置元素
        Collections.swap(list,2,3);
        System.out.println(list);

        //指定元素替换所有元素，初始化
        Collections.fill(list,1);
        System.out.println(list);

        //返回指定元素的个数
        System.out.println(Collections.frequency(collection, 1));

        //两集合没有相同元素，返回true
        System.out.println(Collections.disjoint(collection, collection2));

        //将列表中指定值的所有元素变为另一个
        Collections.replaceAll(list,1,"s");
        System.out.println(list);

        //将列表B的元素覆盖列表A的元素,B比A元素少前提下
        Collections.copy(list,list2);
        System.out.println(list2);
        System.out.println(list);

        //线程安全（不是绝对的线程安全）,它是将map的每个方法都加了同步(都加了虚拟锁机制)
        //但是多个方法合在一起还是会线程不安全，建议加上同步机制
        Collections.synchronizedList(new ArrayList<>());
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedSet(new HashSet<>());
    }
}
