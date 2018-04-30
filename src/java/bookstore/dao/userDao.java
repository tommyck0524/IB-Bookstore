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

    private String url;
    private String dbLoginId;
    private String dbPwd;

    public userDao(String url, String dbLoginId, String dbPwd) {
        this.url = url;
        this.dbLoginId = dbLoginId;
        this.dbPwd = dbPwd;
    }
      
    public boolean userIsValid(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
                     return true;
            }
            return false;
    }
    
     public String getAttribute (String attribute,String username) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
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
     
     
    public String checkRole(String username) throws ClassNotFoundException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM [users]");
            while (rs != null && rs.next() != false) {
                if (rs.getString("username").equals(username))
                    return rs.getString("role");
            }
            return "default";
    }
    
     public boolean insertSuccess(String username, String password, String email) throws ClassNotFoundException, SQLException {
        Connection con;
        ResultSet rs;
        Statement stmt;
        String role = "customer";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
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
    
    public String checkInputDuplicate(String username, String email) throws ClassNotFoundException, SQLException {
        Connection con;
        ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
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
            java.lang.String url = this.url;
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = this.dbLoginId; // database login ID 
            String dbPwd = this.dbPwd; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);       
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users where username = ?");               
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            userId = rs.getInt("UID");
            }
         } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            
        } finally {
             return userId;
        }
    }
    
    public int getCurrentLoaylityPoints(String username) {
		int loyalityPoints = 0;
		try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);       
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users where username = ?");               
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            loyalityPoints = rs.getInt("loyality");
         } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            
        } finally {
           
        }
        return loyalityPoints;
	}
	
	public void setLoyalityPoints(String username, double loyalityPoints) {
		 try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            String sqlStatement = "Update user set[loyality]=? where username=?";
            PreparedStatement pstmt = con.prepareStatement(sqlStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setDouble(1, loyalityPoints);
            pstmt.setString(2, username);

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } finally {

        }
	}
}
