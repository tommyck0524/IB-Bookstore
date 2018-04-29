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
    
     public String getAttribute (String attribute,String username,String dbuser,String dbpw,String dburl) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpw);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username)){
                    if(attribute.equals("UID"))
                     return rs.getString("UID");
                    else if(attribute.equals("email"))
                        return rs.getString("email");
                }
            }
            return null;
    }
     
     
    public String checkRole(String username,String dbuser,String dbpw,String dburl) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpw);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
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
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO [users] ([username], [password], [role], [email]) VALUES (?,?,?,?)",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,role);
            pstmt.setString(4,email);
            pstmt.executeUpdate();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
                     return true;
            }
                return false;
    }
    
    public String checkInputDuplicate(String username, String email,String dbuser,String dbpw,String dburl) throws ClassNotFoundException, SQLException {
        Connection con;
        ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TestDB", "sa", "Tommy6565,.");
            PreparedStatement pstmt = con.prepareStatement("SELECT [username], [email] FROM [users]",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username))
                     return "usernameDup";
                else if(rs.getString("email").equals(email))
                     return "emailDup";
            }
                return "noDup";
    }
    
    public int getUserIdByUserName(String username) {
        int userId = 0;
        try {
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);       
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users where username = ?");               
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            userId = rs.getInt("UID");
         } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            
        } finally {
           
        }
        return userId;
    }
}
