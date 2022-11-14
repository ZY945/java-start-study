package Lambda_stu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;

/**
 * @author 伍六七
 * @date 2022/11/8 12:15
 */
public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        ArrayList<Integer> object2 = objects;
        objects.add(2);
        objects.add(1);
        objects.add(2);
        objects.add(2);
        objects.forEach(integer -> System.out.print(integer));
        System.out.println();
        objects.sort(((Integer o1, Integer o2) -> {
            return o1 - o2;
        }));
        objects.forEach(integer -> System.out.print(integer));
        System.out.println();
        object2.sort((o1, o2) -> o1.compareTo(o2));

        object2.forEach(integer -> System.out.print(integer));
    }
}
