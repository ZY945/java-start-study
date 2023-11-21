/**
 * @author 伍六七
 * @date 2023/6/5 12:50
 */
public class NullPoint {
    public static void main(String[] args) {
        Integer a = null;
        Integer res = a / 2;
        System.out.println(res);
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "a" is null
        //	at NullPoint.main(NullPoint.java:8)

        //jdk8
        //Exception in thread "main" java.lang.NullPointerException
        //	at stream_stu.NullPoint.main(NullPoint.java:13)
    }
}
