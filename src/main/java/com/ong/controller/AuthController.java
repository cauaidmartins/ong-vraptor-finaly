/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.ong.components.AuthSession;
import com.ong.model.Credentials;
import javax.inject.Inject;

/**
 *
 * @author Lucas Rasec
 */
@Controller
public class AuthController {
    
    @Inject
    private AuthSession authSession;

    @Inject
    private Result result;
    
    @Get("signin")
    public void login(){
        
    }
    
    @Post("auth")
    public void authenticate(Credentials credentials){
      
        if (credentials.getOngName().equalsIgnoreCase("ONGX") && 
                credentials.getPassword().equals("admin")){
            authSession.setOngName(credentials.getOngName());
            authSession.setIsLogged(true);
            result.redirectTo(OngController.class).listOng();
        }else{
            result.include("loginErrorMsg", "Login inválido!");
            result.redirectTo(this).login();
        }   
    }
    
    @Get("signout")
    public void signout(){
       authSession.signout();
       result.redirectTo(this).login();
    }

}
