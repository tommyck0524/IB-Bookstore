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
    
     public ArrayList<RefundRequestBean> getRRList(String dbuser, String dbpw, String dburl) throws ClassNotFoundException, SQLException {
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            String sqlStatement = "SELECT * FROM [refundRequest]";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpw);
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
    
}
