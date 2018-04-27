/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hochikeung
 */
public class userDao {

   
    public boolean userIsValid(String username, String password,String dbuser,String dbpw,String dburl) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpw);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
                     return true;
            }
            return false;
    }
     
    public String checkRole(String username,String dbuser,String dbpw,String dburl) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpw);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [roles]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username))
                    return rs.getString("role");
            }
            return "default";
    }
    
    public boolean insertSuccess(String username, String password, String email,String dbuser,String dbpw,String dburl) throws ClassNotFoundException, SQLException {
        Connection con;
        ResultSet rs;
        Statement stmt;
        String role = "customer";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TestDB", "sa", "Tommy6565,.");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO [users] ([username], [password]) VALUES (?, ?)",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.executeUpdate();
            PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO [roles] ([username], [role]) VALUES (?, ?)",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt1.setString(1,username);
            pstmt1.setString(2,role);
            pstmt1.executeUpdate();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
                     return true;
            }
                return false;
    }
}
