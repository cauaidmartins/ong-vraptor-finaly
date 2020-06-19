/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.model;

/**
 *
 * @author Lucas Rasec
 */
public class Credentials {
    
    private String ongName;
    private String password;

    public Credentials() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOngName() {
        return ongName;
    }

    public void setOngName(String userName) {
        this.ongName = ongName;
    }
        
}
