package com.ong.service;

import java.util.List;
import com.ong.dao.OngDAO;
import com.ong.model.Ong;
import com.ong.util.exceptions.LibraryException;

public class OngService {

    private OngDAO ongDAO = new OngDAO();

    public void save(Ong ong) throws LibraryException {
        if (ong.getName() == null || ong.getName().isEmpty()) {
            throw new LibraryException("Por favor, preencha o nome do cliente!");
        }

        ongDAO.save(ong);
    }

    public void update(Ong ong) {
        ongDAO.update(ong);
    }

    public Ong findById(Integer id) {
        return ongDAO.findById(id);
    }

    public void remove(Ong ong) {
        ongDAO.remove(ong);
    }

    public List<Ong> findByName(String name) {
        return ongDAO.findByName(name);
    }

    public List<Ong> list() {
        return ongDAO.findAll();
    }

}
