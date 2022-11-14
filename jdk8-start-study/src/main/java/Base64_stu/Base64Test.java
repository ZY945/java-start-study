package Base64_stu;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 伍六七
 * @date 2022/11/10 10:50
 */
public class Base64Test {
    public static void main(String[] args) {
        String str = "这条信息将会被Base64编码";
        //Base64不只是可以对字符串进行编码，任何byte[]数据都可以，编码结果可以是byte[]，也可以
        String encodeToString = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println("编码后"+encodeToString);
        System.out.println("解码后"+new String(Base64.getDecoder().decode(encodeToString)));
    }
}
