/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao;

import bookstore.JavaBeans.PurchaseBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hochikeung
 */
public class purchaseHistoryDao {
     private String url;
    private String dbLoginId;
    private String dbPwd;

    public purchaseHistoryDao(String url, String dbLoginId, String dbPwd) {
        this.url = url;
        this.dbLoginId = dbLoginId;
        this.dbPwd = dbPwd;
    }
   

   
    
    
    public ArrayList<PurchaseBean> getPBList(String UID) throws ClassNotFoundException, SQLException {
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            String sqlStatement = "SELECT * FROM [purchaseHistory] WHERE [UID] = ? AND [refund]= 1";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url, this.dbLoginId, this.dbPwd);
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,UID);
            rs = pstmt.executeQuery();
            ArrayList <PurchaseBean> PBList = new ArrayList<PurchaseBean>();
            while (rs != null && rs.next() != false) {
                String PID = rs.getString("PID");
                String BID = rs.getString("BID");
                boolean refund = rs.getBoolean("refund");
                PurchaseBean pb = new PurchaseBean(PID,UID,BID,refund);
                PBList.add(pb);
            }
                return PBList;
    }
    
     public void insertPurchaseRecord(int UID,int BID, int quantity, int refund, double total) throws ClassNotFoundException, SQLException {

            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);  
            String sqlStatement = "INSERT INTO [purchaseHistory]([UID],[BID],[quantity],[refund],[total]) VALUES (?,?,?,?,?)";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setInt(1,UID);
            pstmt.setInt(2,BID);
            pstmt.setInt(3,quantity);
            pstmt.setInt(4,refund);
            pstmt.setDouble(5,total);
            pstmt.executeUpdate();
    }
}
