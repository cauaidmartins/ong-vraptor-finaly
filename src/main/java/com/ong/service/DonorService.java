package com.ong.service;

import java.util.List;
import com.ong.dao.DonorDAO;
import com.ong.model.Donor;

import com.ong.util.exceptions.LibraryException;

public class DonorService {

    private DonorDAO donorDAO = new DonorDAO();

    public void save(Donor donor) throws LibraryException {
        if (donor.getName() == null || donor.getName().isEmpty()) {
            throw new LibraryException("Por favor, preencha o nome do Doador!");
        }

        donorDAO.save(donor);
    }

    public void update(Donor donor) {
        donorDAO.update(donor);
    }

    public Donor findById(Integer id) {
        return donorDAO.findById(id);
    }

    public void remove(Donor donor) {
        donorDAO.remove(donor);
    }

    public List<Donor> findByName(String name) {
        return donorDAO.findByName(name);
    }

    public List<Donor> list() {
        return donorDAO.findAll();
    }

}
