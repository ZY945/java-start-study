package collection.collection_s;

import java.util.Arrays;

/**
 * @author 伍六七
 * @date 2022/8/13 20:18
 */
public class arrays_tool {
    public static void main(String[] args) {
        int[] a1 = {8,7,6,5};
        int[] a2 = {1,2,3,4};
        //返回指定数组的内容的字符串表示形式
        System.out.println(Arrays.toString(a1));//[8, 7, 6, 5]

        //根据指定数组的内容返回哈希码
        System.out.println(Arrays.hashCode(a1));//1168767

        //判断两个数组是否相同
        System.out.println(a1.equals(a2));//false

        //将数组转化成 list 集合形式
        System.out.println(Arrays.asList(Arrays.toString(a1)));//[[8, 7, 6, 5]]
        //该list并非java.util.ArrayList类，而是Arrays类的静态内部类
        System.out.println(Arrays.asList(Arrays.toString(a1)).getClass());//class java.util.Arrays$ArrayList

        //排序
        Arrays.sort(a1);//[5, 6, 7, 8]
        System.out.println(Arrays.toString(a1));

        //将数组里的所有元素都替换为指定值------左闭右开
        Arrays.fill(a1,1,2,2);//下标对应换成2
        System.out.println(Arrays.toString(a1));//[5, 2, 7, 8]

        //复制指定的数组(长度超过原数组的部分补0)
        int[] a3 = Arrays.copyOf(a1,5);//[5, 2, 7, 8, 0]
        System.out.println(Arrays.toString(a3));

        //将指定数组的指定范围复制到新数组中------左闭右开
        int[] a4 = Arrays.copyOfRange(a1,2,3);
        System.out.println(Arrays.toString(a4));//[7]
    }
}
