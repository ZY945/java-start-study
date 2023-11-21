package ExceptionDemo;

import java.sql.SQLException;

/**
 * @author 伍六七
 * @date 2023/4/3 16:27
 */
public class Exception {
    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm_db?serverTimezone=UTC", "root", "root");
//        System.out.println(connection);
        System.out.println(test()+"  sss");
    }

    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            int i=1/0;
            return temp;
        } catch (java.lang.Exception e) {
            System.out.println(temp);
            temp=5;
            return temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
//        return temp;
    }
}
