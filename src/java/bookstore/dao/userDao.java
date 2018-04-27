/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hochikeung
 */
public class userDao {
    
    public boolean userIsValid(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TestDB", "sa", "Tommy6565,.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
                     return true;
            }
            return false;
    }
     
    public String checkRole(String username) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TestDB", "sa", "Tommy6565,.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [roles]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username))
                    return rs.getString("role");
            }
            return "default";
    }
    
    public boolean insertSuccess(String username, String password, String email) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        Statement stmt1 = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TestDB", "sa", "Tommy6565,.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate("INSERT INTO [users] ([username],[password],[email]) VALUES('" + username +"','"+password+"','"+email+"')");
            stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt1.executeQuery("SELECT * FROM [users]");
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
                     return true;
            }
                return false;
    }
}
