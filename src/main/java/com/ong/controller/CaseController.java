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
import com.ong.dao.CaseDAO;
import com.ong.model.Case;
import java.util.List;
import javax.inject.Inject;


/**
 *
 * @author Lucas Rasec
 */

@Controller
@Path("case")
public class CaseController {
    @Inject
    private Result result;

    @Inject
    private CaseDAO caseDAO;

    @Get("novo")
    public void newCase() {
    }

    @Post("novo")
    public void newCase(Case ca) {
        caseDAO.save(ca);
        result.redirectTo(this).listCase();
    }

    @Post("atualizar")
    public void editCase(Case user) {
        caseDAO.update(user);
        result.redirectTo(this).listCase();
    }

    @Get("editar/{id}")
    public void editUser(Integer id) {
        Case ca = caseDAO.findById(id);
        result.include("case", ca);

    }

    @Get("lista")
    public void listCase() {

        List<Case> ca = caseDAO.findAll();
        for (Case ca1 : ca) {
            System.out.println(ca1.getCode());
        }
        result.include("case", ca);
    }

    @Get("remover/{id}")
    public void removeCase(Integer id) {

        Case ca = caseDAO.findById(id);
        result.include("case", ca);
        caseDAO.remove(ca);
        result.redirectTo(this).listCase();
    }

    @Public
    @Post("listar")
    public void simpleSearch(Integer caseId) {

        List<Case> ca = (List<Case>) caseDAO.findById(caseId);
        result.include("ca", ca);
        result.of(this).listCase();

    }
}
