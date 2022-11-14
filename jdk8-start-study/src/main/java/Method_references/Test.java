package Method_references;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 伍六七
 * @date 2022/11/8 12:27
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = list;
        ArrayList<Integer> list3 = list;
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(1);
        list.forEach(System.out::print);
        System.out.println();


        //方法引用
        Collections.sort(list, Integer::compareTo);
        list.forEach(System.out::print);
        System.out.println();
        //Lambda
        Collections.sort(list2, (o1, o2) -> o1.compareTo(o2));
        list2.forEach(System.out::print);
        System.out.println();
        //重写
        Collections.sort(list3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        list3.forEach(System.out::print);

    }
}
