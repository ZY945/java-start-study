import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 伍六七
 * @date 2022/9/5 8:25
 */
public class mytest {
    /**
     * random
     */
    @Test
    public void random1() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int i = random.nextInt(100) + 1;
        while (true) {
            int res = scanner.nextInt();
            if (res == i) {
                break;
            } else if (res > i) {
                System.out.println("大了");
            } else if (res < i) {
                System.out.println("小了");
            }
        }
    }


    @Test
    public void suShu() {
        boolean a=false;
        for(int i=100;i<201;i++){
            a=false;
            for(int j=2;j<i-1;j++){
                if(i%j==0){
                    a=true;
                    break;
                }
            }
            if(!a){
                System.out.print(i+" ");
            }
        }
    }

    /**
     *测试数组集合的互相转化
     */
    @Test
    public void listTest(){
        int[] intArr = {998, 77, 66, 89, 79, 50, 100};
        Integer[] integerArr = {998, 77, 66, 89, 79, 50, 100};
        System.out.println("int数组为"+Arrays.toString(intArr));
        System.out.println("Integer数组为"+Arrays.toString(integerArr));
        List<int[]> intList = Arrays.asList(intArr);
        System.out.println(intList);
        System.out.println(intList.getClass().getTypeName());


        List<Integer> integerList = Arrays.asList(integerArr);
        System.out.println(integerList);
        System.out.println(integerList.getClass().getTypeName());


        Object[] array = intList.toArray();
        System.out.println(array);
        System.out.println(array.getClass().getTypeName());
        Object[] objects = integerList.toArray();
        System.out.println(objects);
        System.out.println(objects.getClass().getTypeName());
    }

    @Test
    public void testarr(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);

    }


    @Test
    public void listStr(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Class class1=list.getClass();
        try {
            Method method= class1.getMethod("add",Object.class);
            //通过反射机制操作list对象
            method.invoke(list,"sss");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listadd() throws IllegalAccessException, NoSuchFieldException {
        ArrayList list = new ArrayList();
        mytest mytest = new mytest();
        System.out.println(mytest.getArrayListCapacity(list));
        System.out.println(list.size());
        for (int i = 0; i < 20; i++) {
            list.add(1);
        }
        System.out.println(mytest.getArrayListCapacity(list));
        System.out.println(list.size());
    }



    public int getArrayListCapacity(ArrayList<?> arrayList) {
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


    @Test
    public void fill(){
        String[] array = new String[10];
        Arrays.fill(array,".");
        System.out.println();
    }
}
