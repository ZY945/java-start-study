package stream_stu;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 伍六七
 * @date 2022/11/7 13:35
 * 合并流需要保证流未关闭
 */
public class stream_merge {
    public static void main(String[] args) {
        Stream<Integer> concat1 = Stream.of(1, 2, 3);
        Stream<Integer> concat2 = Stream.of(4, 5, 6);
        Stream<Integer> concat3 = Stream.of(7, 8, 9);

        Stream<Integer> flatMap1 = Stream.of(1, 2, 3);
        Stream<Integer> flatMap2 = Stream.of(4, 5, 6);
        Stream<Integer> flatMap3 = Stream.of(7, 8, 9);
        Stream<Integer> flatMap4 = Stream.of(0);

        //concat合并流
        Stream<Integer> concat = Stream.concat(Stream.concat(concat1, concat2),concat3);
        List<Integer> collect = concat.collect(Collectors.toList());
        System.out.println(collect);//[1, 2, 3, 4, 5, 6, 7, 8, 9]

        //flatMap合并流
        Stream<Integer> flatMap = Stream.of(flatMap1,flatMap2,flatMap3,flatMap4).
                flatMap(integerStream -> integerStream);
        List<Integer> collect1 = flatMap.collect(Collectors.toList());
        System.out.println(collect1);//[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

        //第三方库和并--需要Reactor依赖

        List<Integer> block = Flux.fromStream(Stream.of(1,2,3))
                .mergeWith(Flux.fromStream(Stream.of(3,4,5)))
                .collectList()
                .block();
        System.out.println("第三方库合并"+block);


        //flatMap拆分流
        List<String> imagePathList  = new ArrayList<>();
        imagePathList.add("10001.jpg;10002.jpg");
        imagePathList.add("10003.jpg;10004.jpg");
        imagePathList.add("10005.jpg;10006.jpg");
        imagePathList.add("10007.jpg;10008.jpg");
        imagePathList.add("10009.jpg;10010.jpg");

        Stream<String> stringStream = imagePathList.stream().flatMap(img -> Arrays.asList((img + ";").split(";")).stream());
        List<String> collect2 = stringStream.collect(Collectors.toList());
        System.out.println(collect2);//[10001.jpg, 10002.jpg, 10003.jpg, 10004.jpg, 10005.jpg, 10006.jpg, 10007.jpg, 10008.jpg, 10009.jpg, 10010.jpg]

    }
}
