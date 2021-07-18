package com.bjpowernode;

import com.bjpowernode.utils.DBUtil;

import java.sql.*;

public class JDBCTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select empno,ename from emp where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,10);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Empno:"+rs.getString("empno")+", Ename:"+rs.getString("ename"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

    }
}
