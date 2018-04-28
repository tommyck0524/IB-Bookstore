/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.JavaBeans;

/**
 *
 * @author chuntkwan2
 */
public class BookBean {
    private int bookId;
    private String bookName;
    private int quantity;
    private String description;
    private double price;
    private String picture;

    public BookBean() {
    }
    
    public BookBean (int bookId, String bookName, int quantity, String description, double price, String picture) {
       setBookId(bookId);
       setBookName(bookName);
        setQuantity(quantity);
         setDescription(description);
         setPrice(price);
         setPicture(picture);
    }
    
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } 
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String url) {
        this.picture = url;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
}
