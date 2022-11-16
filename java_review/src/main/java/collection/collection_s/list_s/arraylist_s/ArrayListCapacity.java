package collection.collection_s.list_s.arraylist_s;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author 伍六七
 * @date 2022/11/16 21:14
 */
public class ArrayListCapacity {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        System.out.println(getArrayListCapacity(list));
        System.out.println(list.size());
        for (int i = 0; i < 20; i++) {
            list.add(1);
        }
        System.out.println(getArrayListCapacity(list));
        System.out.println(list.size());
    }

    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[])field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
