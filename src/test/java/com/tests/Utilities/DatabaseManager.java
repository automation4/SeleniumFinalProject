package com.tests.Utilities;

import com.tests.Constant;
import org.testng.annotations.Test;

import java.sql.*;

public class DatabaseManager {
    private static Connection conn = null;

    private static void getDBCOnnection() throws SQLException {
        conn = DriverManager.getConnection(Constant.DB_URL,Constant.DB_USER, Constant.DB_PASS);

        if(!conn.isClosed()){
            System.out.println("we have successfully connected to database");
        }
    }

    public static ResultSet getData(String sql) throws SQLException {
        getDBCOnnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public static void getUserCreds() throws SQLException {
        String query = "select user, pass from UserCreds limit 1";
        ResultSet rs1 = DatabaseManager.getData(query);
        rs1.next();
        rs1.getString("UserName");
        rs1.getString("Passworde");
    }

}
