package donshin.basicjdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static donshin.basicjdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    /**
     * DriverManager 를 통해 DB Connection 을 획득한다.
     * DriverManager.getConnection 에서 획득 실패 시, SQLException 이 발생한다.
     */
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={}, class={}", con, con.getClass());
            return con;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
