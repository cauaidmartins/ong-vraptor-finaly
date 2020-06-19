package com.ong.components;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Martins
 */
@SessionScoped
public class AuthSession implements Serializable{
    
    private boolean isLogged;
    private String ongName;

    public void setOngName(String ongName) {
        this.ongName = ongName;
    }
    
    public boolean isLogged(){
        System.out.println("isLogged " + isLogged);
        return isLogged;
    }

    public String getUserName() {
        return ongName;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public void signout(){
        this.isLogged = false;
        this.ongName = null;
    }
    
    
    
    
}