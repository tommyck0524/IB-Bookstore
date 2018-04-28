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
   private String bookName;
   private String purchaseQuantity;

    public Transaction(String bookName, String purchaseQuantity) {
        this.bookName = bookName;
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(String purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
    
    
   
}
