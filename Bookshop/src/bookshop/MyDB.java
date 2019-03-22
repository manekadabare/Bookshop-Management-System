/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author SHEHAN
 */
public class MyDB {
    private static Connection c;
    private static void setConnection()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bookshop", "root", "123");
    }
    public static void iud(String sql)throws Exception{
        if (c==null) {
            setConnection();
        }
        c.createStatement().executeUpdate(sql);
    }
    public static ResultSet search(String sql)throws Exception{
        if (c==null) {
            setConnection();
        }
        return c.createStatement().executeQuery(sql);
    }
    public static Connection newCon() throws Exception{
        if (c==null) {
            setConnection();
        }
        return c;
    }
}
