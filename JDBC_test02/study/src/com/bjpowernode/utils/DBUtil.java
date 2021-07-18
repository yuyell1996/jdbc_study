package com.bjpowernode.utils;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static ResourceBundle db = ResourceBundle.getBundle("resources/db");
    static {
        try{
            Class.forName(db.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(db.getString("url"),db.getString("user"),db.getString("password"));
        return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt!=null){
            try{
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
