package utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SqlUtil {

    public static void executeUpdate(Connection conn, String sql, Object... args) {
        PreparedStatement pre = null;
        try {
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.releaseSource(null, pre, conn);
        }
    }

    public static <T> T executeQuerySingle(Connection conn, String sql, Class<T> clazz, Object... args) {
        return executeQuery(conn, sql, clazz, args).get(0);
    }

    public static <T> List<T> executeQuery(Connection conn, String sql, Class<T> clazz, Object... args) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            rs = pre.executeQuery();
            ResultSetMetaData resultSetMD = rs.getMetaData();
            int columnCount = resultSetMD.getColumnCount();
            Field field = clazz.getDeclaredFields()[0];
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = resultSetMD.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(columnName);
                    try {
                        field = clazz.getDeclaredField(columnName);
                    } catch (Exception e){
                        List<Field> fieldList = getFieldList(clazz);
                        for (Field f : fieldList) {
                            String columnLabel = Optional.ofNullable(f.getAnnotation(ColumnName.class))
                                .map(ColumnName::value)
                                .orElse(f.getName());
                            if (columnLabel.equals(columnName)) {
                                field = f;
                                break;
                            }
                        }
                    }
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.releaseSource(rs, pre, conn);
        }
        return list;
    }

    private static <T> List<Field> getFieldList(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(fields));
        Class<? super T> superClass = clazz.getSuperclass();
        while (superClass != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(superClass.getDeclaredFields())));
            superClass = superClass.getSuperclass();
        }
        return fieldList;
    }
}
