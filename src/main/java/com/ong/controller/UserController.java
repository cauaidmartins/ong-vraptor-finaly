package com.ong.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.ong.annotations.Public;
import com.ong.dao.UserDAO;
import com.ong.model.User;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Martins
 */
@Controller
@Path("user")
public class UserController {

    @Inject
    private Result result;

    @Inject
    private UserDAO userDAO;

    @Get("novo")
    public void newUser() {
    }

    @Post("novo")
    public void newUser(User user) {
        userDAO.save(user);
        result.redirectTo(this).listUser();
    }

    @Post("atualizar")
    public void editUser(User user) {
        userDAO.update(user);
        result.redirectTo(this).listUser();
    }

    @Get("editar/{id}")
    public void editUser(Integer id) {
        User user = userDAO.findById(id);
        result.include("user", user);

    }

    @Get("lista")
    public void listUser() {

        List<User> user = userDAO.findAll();
        for (User user1 : user) {
            System.out.println(user1.getName());
        }
        result.include("it", user);
    }

    @Get("remover/{id}")
    public void removeUser(Integer id) {

        User user = userDAO.findById(id);
        result.include("user", user);
        userDAO.remove(id);
        result.redirectTo(this).listUser();
    }

    @Public
    @Post("simples")
    public void simpleSearch(String userName) {

        List<User> user = (List<User>) userDAO.findByName(userName);
        result.include("it", user);
        result.of(this).listUser();

    }
}
