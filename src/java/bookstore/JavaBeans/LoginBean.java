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
public class LoginBean {
    
    private String loginID;
    private String password;

    
    public void setLoginID(String loginID){
        loginID = loginID;
    }
    
    public String getLoginID(){
        return loginID;
    }   
    
    public void setPassword(String password){
        password = password;
    } 
    
    public String getPassword(){
        return password;
    }     
    
    public boolean validate (String loginID,String password){
        if(loginID.equals("abc123") && password.equals("abc456"))
            return true;
        else
            return false;
        }
    
}

