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
    
    public ArrayList<PurchaseBean> getPBList(String UID,String dbuser, String dbpw, String dburl) throws ClassNotFoundException, SQLException {
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            String sqlStatement = "SELECT * FROM [purchaseHistory] WHERE [UID] = ? AND [refund]= 1";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpw);
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
}
