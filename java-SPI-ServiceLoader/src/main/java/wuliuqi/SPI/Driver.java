package wuliuqi.SPI;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 伍六七
 * @date 2023/4/3 10:58
 */
public interface Driver {
    Connection connect(String url,java.util.Properties info)
        throws SQLException;
}
