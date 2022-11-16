package Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 伍六七
 * @date 2022/9/8 11:13
 */
public class array_study {
    /**
     * new int[]后地址就确定了
     * 一个数组指向另一个数组，两个数组对内容的修改会同步
     * 方法：
     * Arrays.toString(数组地址)---[1，2]
     * @param args
     */
    public static void main(String[] args) {
        int a = 13;
        int[] array = new int[3];
        int[] array1 = array;
        System.out.println(array);
        System.out.println(array1);
        array[0]=a;
        System.out.println(array[0]);
        System.out.println(array1[0]);
        array1[0]=123;
        System.out.println(array[0]);
        System.out.println(array1[0]);
        System.out.println(Arrays.toString(idea()));
    }
    public static int[] idea(){
        int[] arr = new int[]{11,22,33,44,55};
        return arr;
    }
}
