package com.ong.components;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import lombok.Data;

/**
 *
 * @author Martins
 */
@Data
@SessionScoped
public class AuthSession implements Serializable {

    private boolean isLogged;
    private String userName;

    public boolean isLogged() {
        System.out.println("isLogged " + isLogged);
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }

    public void signout() {
        this.isLogged = false;
        this.userName = null;
    }

}
