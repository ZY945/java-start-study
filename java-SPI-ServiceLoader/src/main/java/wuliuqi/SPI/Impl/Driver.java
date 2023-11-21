package wuliuqi.SPI.Impl;

import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.SQLException;

/**
 * @author 伍六七
 * @date 2023/4/3 11:01
 */
public class Driver extends NonRegisteringDriver implements java.sql.Driver{
    static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
            System.out.println("successs");
        } catch (SQLException e) {
            throw new RuntimeException("fail register driver!" + e);
        }
    }

    public Driver() throws SQLException {
    }
}
