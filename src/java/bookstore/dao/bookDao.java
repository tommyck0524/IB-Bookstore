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
import java.util.List;
import bookstore.JavaBeans.BookBean;
import java.util.ArrayList;
/**
 *
 * @author chuntkwan2
 */
public class bookDao {
    
    public List<BookBean> retriveBookList() {
         List<BookBean> booklist = new ArrayList<>(); 
        try {
           
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");
            while (rs.next()) {
            BookBean book = new BookBean(rs.getInt("bookid"),rs.getString("bookname"),rs.getInt("quantity"), rs.getString("description"), rs.getDouble("price"), rs.getString("picture"));
            booklist.add((book));          
            }
            stmt.close();
            con.close();
                
           
        } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            
        } finally {
           
        }
        return booklist;
    }
     
}
