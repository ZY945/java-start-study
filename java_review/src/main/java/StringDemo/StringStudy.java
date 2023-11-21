package StringDemo;

import java.util.*;

/**
 * @author 伍六七
 * @date 2023/9/3 10:42
 */
public class StringStudy {


    public static void main(String[] args) {
    }

    /**
     * 字母异位词分组
     */
    private static void group() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            List<String> list = map.getOrDefault(str, new ArrayList<>());
            list.add(s);
            map.put(str,list);
        }
        ArrayList<List<String>> lists = new ArrayList<>(map.values());
        System.out.println(lists);
    }
}
