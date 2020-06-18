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

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
