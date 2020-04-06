package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class JDBCUtil {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        Properties pro = new Properties();
        ClassLoader classLoader = JDBCUtil.class.getClassLoader();
        URL url = classLoader.getResource("jdbc.properties");
        String path = Objects.requireNonNull(url).getPath();
        try {
            pro.load(new FileReader(path));
            URL = pro.getProperty("URL");
            USER = pro.getProperty("USER");
            PASSWORD = pro.getProperty("PASSWORD");
            Class.forName(pro.getProperty("DRIVER"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void releaseSource(ResultSet res, Statement pre, Connection conn) {
        if (null != res) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != pre) {
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
