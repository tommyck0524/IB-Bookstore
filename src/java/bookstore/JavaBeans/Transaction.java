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
public class Transaction {
   private int transactionId;
   private String bookName;  
   private double price;
   private int purchaseQuantity;
   private double total;

    public Transaction(int transactionId, String bookName, double price, int purchaseQuantity) {
        this.transactionId = transactionId;
        this.bookName = bookName;
        this.price = price;
        this.purchaseQuantity = purchaseQuantity;
        this.total = price*purchaseQuantity;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
    
    
   
}
