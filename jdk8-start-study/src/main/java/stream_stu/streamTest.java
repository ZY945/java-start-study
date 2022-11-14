package stream_stu;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 伍六七
 * @date 2022/11/7 13:16
 */

/**
 * stream()
 * filter
 * limit
 * collect(Collectors.toList())
 */

/**
 * 1. 直接合并流
 * 2. 分割完合并
 */
public class streamTest {
    public static void main(String[] args) {
        ArrayList<User> objects = new ArrayList<>();
        objects.add(new User("A", 18, "男"));
        objects.add(new User("B", 18, "男"));
        objects.add(new User("C", 16, "女"));
        //形成流
        Stream<User> userStream = objects.stream().filter(user1 -> user1.getAge().equals(18)).limit(1);

        System.out.println("skip"+objects.stream().limit(3).skip(1).collect(Collectors.toList()));

        List<User> collect = userStream.collect(Collectors.toList());
        collect.forEach(user1 -> System.out.println(user1));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        boolean result = list.stream()
                .anyMatch(x->x>5);//有一个匹配即可
        boolean result1 = list.stream()
                .allMatch(x->x>5);//全部匹配
        boolean result2 = list.stream()
                .noneMatch(x->x>5);//全部不匹配
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);

        System.out.println(Stream.of(4, 1, 3, 5, 9)
                .map(u -> u + 1).sorted((x,y) -> x-y)
                .collect(Collectors.toList()));

        IntSummaryStatistics intSummaryStatistics = Stream.of(1, 3, 5, 7, 9)
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getSum());
    }
}
