package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 伍六七
 * @date 2023/8/5 21:39
 */
public class StrDemo {
    public static void main(String[] args) {
        System.out.println(MoveTheLetters("abcdef",3));
    }
    //////////////////////String//////////////////////
    /**
     * 给定一个字符串比如“abcdef”，要求写个函数变成“defabc”
     * @param str
     * @param index
     * @return
     */
    public static String MoveTheLetters(String str,int index){
        return str.substring(index)+str.substring(0,index);
    }

    /**
     * 字母异位词分组
     */
    private static void group() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, List<String>> map = new HashMap<>();
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
