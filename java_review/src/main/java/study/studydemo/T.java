package study.studydemo;

import java.util.Map;

/**
 * @author dongfeng
 * @since 2023-12-02 18:25
 */
public class T {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        env.entrySet().forEach(System.out::println);
    }

}
