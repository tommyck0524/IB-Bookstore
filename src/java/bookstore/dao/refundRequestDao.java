/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao;

import bookstore.JavaBeans.PurchaseBean;
import bookstore.JavaBeans.RefundRequestBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hochikeung
 */
public class refundRequestDao {
     private String url;
    private String dbLoginId;
    private String dbPwd;

    public refundRequestDao(String url, String dbLoginId, String dbPwd) {
        this.url = url;
        this.dbLoginId = dbLoginId;
        this.dbPwd = dbPwd;
    }
    
    
     public ArrayList<RefundRequestBean> getRRList() throws ClassNotFoundException, SQLException {
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            String sqlStatement = "SELECT * FROM [refundRequest]";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();
            ArrayList <RefundRequestBean> RRList = new ArrayList<RefundRequestBean>();
            while (rs != null && rs.next() != false) {
                String RID = rs.getString("RID");
                String PID = rs.getString("PID");
                RefundRequestBean rr = new RefundRequestBean(RID,PID);
                RRList.add(rr);
            }
                return RRList;
    }
     public void insertRefundRequest(String PID) throws ClassNotFoundException, SQLException {
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            String sqlStatement = "INSERT INTO [refundRequest] VALUES(?)";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,PID);
            pstmt.executeUpdate();
    }
     
       public String getRID(String PID) throws ClassNotFoundException, SQLException {
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            String sqlStatement = "SELECT * FROM [refundRequest]";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();
            while (rs != null && rs.next() != false) {
                if(rs.getString("PID").equals(PID))
                return rs.getString("RID");
            }
            return null;
    }
       
       public void deleteRequest(String RID) throws ClassNotFoundException, SQLException {
            Connection con = null;
            String sqlStatement = "DELETE FROM [refundRequest] where RID = ?";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,RID);
            pstmt.executeUpdate();
    }
    
}
