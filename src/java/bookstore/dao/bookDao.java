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
import java.sql.PreparedStatement;
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
                BookBean book = new BookBean(rs.getInt("bookid"), rs.getString("bookname"), rs.getInt("quantity"), rs.getString("description"), rs.getDouble("price"), rs.getString("picture"));
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

    public List<BookBean> getSelectedBookInfo(String bookName) {
        List<BookBean> booklist = new ArrayList<>();
        try {
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM book where bookName = ?");
            pstmt.setString(1, bookName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BookBean book = new BookBean(rs.getInt("bookid"), rs.getString("bookname"), rs.getInt("quantity"), rs.getString("description"), rs.getDouble("price"), rs.getString("picture"));
                booklist.add((book));
            }
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } finally {

        }
        return booklist;
    }

    public int getBookIdByBookName(String bookName) {
        int bookId = 0;
        try {
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM book where bookname = 'sea'");
            //pstmt.setString(1, bookName);
            ResultSet rs = pstmt.executeQuery();
            bookId = rs.getInt("bookid");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } finally {

        }
        return bookId;
    }

    public void updateBookInfo(String bookName, String quantity, String description, String price, String picture) {
        try {
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } finally {

        }
    }

    public void addBook(String bookName, String quantity, String description, String price, String picture) {
        try {
            int quantity_int = 0;
            double price_double = 0;
            if(quantity!=null) {
                quantity_int=Integer.parseInt(quantity);
            }
            if(quantity!=null) {
                price_double=Double.parseDouble(price);
            }
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);
 String sqlStatement = "INSERT INTO [book]([bookname],[quantity],[description],[price],[picture]) VALUES (?,?,?,?,?)";
 PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,bookName);
            pstmt.setInt(2,quantity_int);
            pstmt.setString(3,description);
            pstmt.setDouble(4,price_double);
            pstmt.setString(5,picture);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } finally {

        }
    }

    public void deleteBook(String bookName) {
        try {
            java.lang.String url = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad022_db;";
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbLoginId = "aiad022"; // database login ID 
            String dbPwd = "aiad022"; // database password 
            Connection con = DriverManager.getConnection(url, dbLoginId, dbPwd);
            String sqlStatement = "DELETE FROM [book] where bookname = ?";
            PreparedStatement pstmt = con.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1,bookName);
            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } finally {

        }
    }

}
