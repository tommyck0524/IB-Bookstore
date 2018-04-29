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
public class RefundRequestBean {

    private String RID;
    private String PID;

    public RefundRequestBean(String RID, String PID) {
        this.RID = RID;
        this.PID = PID;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
    
    
}
