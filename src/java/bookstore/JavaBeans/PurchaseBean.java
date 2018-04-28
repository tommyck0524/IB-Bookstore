/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.JavaBeans;

/**
 *
 * @author hochikeung
 */
public class PurchaseBean {
    private String PID;
    private String UID;
    private String BID;
    private boolean refund;

    public PurchaseBean(String PID, String UID, String BID, boolean refund) {
        this.PID = PID;
        this.UID = UID;
        this.BID = BID;
        this.refund = refund;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }
    
    
    
}
