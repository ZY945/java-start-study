package Lambda_stu;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

/**
 * @author 伍六七
 * @date 2022/11/8 12:15
 */
public class Lambda {
    public static void main(String[] args) {
        Demo();
    }

    private static void forDemo() {
        List<String> list = Arrays.asList("XiaoMing", "XiaoHong", "XiaoWang");
        list.forEach(System.out::println);
    }

    private static void sortDemo() {
        List<String> list = Arrays.asList("XiaoMing", "XiaoHong", "XiaoWang");
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }

    private static void filterDemo() {
        List<String> list = Arrays.asList("XiaoMing", "XiaoHong", "XiaoWang");
        List<String> newList = list.stream().filter(s -> s.startsWith("XiaoM")).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

    private static void mapDemo() {
        List<String> list = Arrays.asList("XiaoMing", "XiaoHong", "XiaoWang");
        List<String> newList = list.stream().map(s -> s.substring(4)).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

    private static void reduceDemo() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void groupingByDemo() {
        List<String> list = Arrays.asList("Java", "Vue", "Golang", "Python", "JavaScript");
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        // key是长度(分组规则)，value是包含相同长度字符串的list
        System.out.println(collect);
    }

    private static void Demo() {
        // 实现J开头的全部小写,并按字母排序
        List<String> list = Arrays.asList("Java", "Vue", "Golang", "Python", "JavaScript");
        List<String> collect = list.stream().filter(s -> s.startsWith("J")).map(String::toLowerCase).sorted().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
