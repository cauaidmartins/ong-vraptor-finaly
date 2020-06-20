/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.ong.annotations.Public;
import com.ong.dao.OngDAO;
import com.ong.model.Ong;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Lucas Rasec
 */

@Controller
@Path("ong")
public class OngController {
    @Inject
    private Result result;

    @Inject
    private OngDAO OngDAO;

    @Get("novo")
    public void newOng() {
    }

    @Post("novo")
    public void newOng(Ong ong) {
        OngDAO.save(ong);
        result.redirectTo(this).listOng();
    }

    @Post("atualizar")
    public void editOng(Ong ong) {
        OngDAO.update(ong);
        result.redirectTo(this).listOng();
    }

    @Get("editar/{id}")
    public void editOng(Integer id) {
        Ong ong = OngDAO.findById(id);
        result.include("ong", ong);

    }

    @Get("lista")
    public void listOng() {

        List<Ong> ong = OngDAO.findAll();
        for (Ong ong1 : ong) {
            System.out.println(ong1.getName());
        }
        result.include("ong", ong);
    }

    @Get("remover/{id}")
    public void removeOng(Integer id) {

        Ong ong = OngDAO.findById(id);
        result.include("ong", ong);
        OngDAO.remove(ong);
        result.redirectTo(this).listOng();
    }

    @Public
    @Post("busca")
    public void simpleSearch(String ongName) {

        List<Ong> ong = (List<Ong>) OngDAO.findByName(ongName);
        result.include("it", ong);
        result.of(this).listOng();

    }
}
