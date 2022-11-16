package collection.collection_s.list_s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 伍六七
 * @date 2022/8/12 20:26
 */
public class list_demo {
    public static void main(String[] args) {
        //0新建[]
        ArrayList list = new ArrayList();


        //1添加[4, 3, 2, 1, s, s]
        list.add("4");
        list.add("3");
        list.add("2");
        list.add(1);
        list.add("s");
        list.add("s");


        //2删除按照索引和按照参数(删除一个)
        list.remove(1);//[4, 2, 1, s, s]
        list.remove("s");//[4, 2, 1, s]

        //3遍历
        //3.1for遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");//4 2 1 s
        }

        //3.2增强for
        for (Object l:list) {
            System.out.print(l+" ");//4 2 1 s

        }

        //3.3迭代器
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object o =  it.next();
            System.out.print(o+" ");//4 2 1 s
            //可以使用it.remove(); 进行移除元素
            //不能使用collection其他方法 会报并发修改异常
//            it.remove();
        }

        //3.4列表迭代器
        ListIterator li = list.listIterator();
        while (li.hasNext()){
            System.out.printf(li.nextIndex()+":"+li.next()+" ");//0:4 1:2 2:1 3:s
        }
        while (li.hasPrevious()){
            System.out.printf(li.previousIndex()+":"+li.previous()+" ");//3:s 2:1 1:2 0:4
        }


        //4获取对应下标
        int i = list.indexOf(1);
        System.out.println(i);//2


        //5返回子集合(左闭右开)
        List list1 = list.subList(1, 3);
        System.out.println(list1);//[2, 1]
    }
}
