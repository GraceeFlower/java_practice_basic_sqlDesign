package repositories;

import entities.GeneralUser;
import utils.JDBCUtil;
import utils.SqlUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class GeneralRepository {

    public static boolean getUser(String[] usrInfo, String tableName) {
        GeneralUser usr = null;
        try {
            Connection conn = JDBCUtil.connectToDB();
            String sql = "SELECT id, name, password FROM " + tableName + " WHERE name = ? AND password = ?";
            usr = SqlUtil.executeQuerySingle(conn, sql, GeneralUser.class, usrInfo[0], usrInfo[1]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usr != null;
    }
}
