import entities.Person;
import entities.Student;
import entities.Teacher;
import utils.JDBCUtil;
import utils.SqlUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Teacher> stu = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.connectToDB();
            String sql = "SELECT username, course, feature_color FROM teacher";
            stu = SqlUtil.executeQuery(conn, sql, Teacher.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stu);
    }

}
