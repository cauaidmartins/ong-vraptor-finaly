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
import com.ong.dao.DonorDAO;
import com.ong.model.Donor;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Martins
 */

@Controller
@Path("donor")
public class DonorController {
    @Inject
    private Result result;

    @Inject
    private DonorDAO DonorDAO;

    @Get("novo")
    public void newDonor() {
    }

    @Post("novo")
    public void newDonor(Donor donor) {
        DonorDAO.save(donor);
        result.redirectTo(this).listDonor();
    }

    @Post("atualizar")
    public void editDonor(Donor donor) {
        DonorDAO.update(donor);
        result.redirectTo(this).listDonor();
    }

    @Get("editar/{id}")
    public void editDonor(Integer id) {
        Donor donor = DonorDAO.findById(id);
        result.include("donor", donor);

    }

    @Get("lista")
    public void listDonor() {

        List<Donor> donor = DonorDAO.findAll();
        for (Donor donor1 : donor) {
            System.out.println(donor1.getName());
        }
        result.include("it", donor);
    }

    @Get("remover/{id}")
    public void removeDonor(Integer id) {

        Donor donor = DonorDAO.findById(id);
        result.include("donor", donor);
        DonorDAO.remove(donor);
        result.redirectTo(this).listDonor();
    }

    @Public
    @Post("busca")
    public void listaSearch(String donorName) {

        List<Donor> donor = (List<Donor>) DonorDAO.findByName(donorName);
        result.include("it", donor);
        result.of(this).listDonor();

    }
}
