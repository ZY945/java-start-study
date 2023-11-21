package al;

/**
 * @author 伍六七
 * @date 2023/8/5 21:39
 */
public class StrDemo {
    public static void main(String[] args) {
        System.out.println(change1("abcdef",3));
    }


    /**
     * 给定一个字符串比如“abcdef”，要求写个函数变成“defabc”
     * @param str
     * @param index
     * @return
     */
    public static String change1(String str,int index){
        return str.substring(index)+str.substring(0,index);
    }

    /**
     * 给定一个字符串比如“abcdef”，要求写个函数变成“defabc”
     * @param str
     * @param index
     * @return
     */
    public static String change2(String str,int index){
        return str.substring(index)+str.substring(0,index);
    }
}
