package collection.collection_s.list_s.linkedlist_s;

import java.util.LinkedList;

/**
 * @author 伍六七
 * @date 2023/8/18 19:32
 */
public class linkedlist_demo {
    public static void main(String[] args) {
        LinkedList<String> str = new LinkedList<>();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add(2,"4");//在指定位置节点新增,for找到位置的
        str.forEach(System.out::print);
        System.out.println();
        String element = str.poll();
        System.out.println(element);
        str.forEach(System.out::print);
    }
}
