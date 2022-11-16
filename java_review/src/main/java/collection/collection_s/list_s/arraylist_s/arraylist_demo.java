package collection.collection_s.list_s.arraylist_s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 伍六七
 * @date 2022/8/12 21:03
 */
public class arraylist_demo {
    public static void main(String[] args) {
        //0新建[]
        ArrayList arrayList  = new ArrayList<>();
        System.out.println(arrayList);//[]


        //1添加
        arrayList.add(1);
        arrayList.add("1");//会自动转化为int
        arrayList.add("s");
        arrayList.add("s");
        arrayList.add("l");
        System.out.println(arrayList);//[1, 1, s, s, l]


        //2删除按照下标(int)按照参数(String)
        arrayList.remove(1);
        System.out.println(arrayList);//[1, s, s, l]

        //3遍历
        //3.1迭代器
        Iterator it = arrayList.iterator();
        while(it.hasNext()){
            Object o = it.next();
            System.out.print(o+" ");//1 s s l
        }


        //3.1列表迭代器
        ListIterator li = arrayList.listIterator();
        //正序
        while(li.hasNext()){
            Object o = li.next();
            System.out.print(o+" ");//1 s s l
        }
        //倒序
        while(li.hasPrevious()){
            Object o = li.previous();
            System.out.printf(o+" ");//l s s 1
        }


        //4判断
        System.out.println(arrayList.contains(1));//true

        System.out.println(arrayList.isEmpty());//false


        //5获得下标
        System.out.println(arrayList.indexOf(1));//0
        System.out.println(arrayList.indexOf("s"));//1
    }
}
