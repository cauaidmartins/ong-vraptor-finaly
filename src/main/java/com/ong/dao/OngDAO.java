/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.dao;

import com.ong.dao.util.ConnectionFactory;
import com.ong.model.Ong;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas Rasec
 */
public class OngDAO {

    public void save(Ong ong) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(ong);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void update(Ong ong) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(ong);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void remove(Ong ong) {
        EntityManager manager = ConnectionFactory.getEntityManager();

        try {
            manager.getTransaction().begin();
            Ong o = manager.find(Ong.class, ong.getCode());
            manager.remove(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public Ong findById(Integer id) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            Ong o = em.find(Ong.class, id);
            return o;
        } finally {
            if (em.isOpen() && em.getTransaction().isActive()) {
                em.close();
            }
        }
    }

    public List<Ong> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Ong> list = em.createQuery("select from Ong")
                .getResultList();
        em.close();
        return list;
    }

    public List<Ong> findAll() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Ong> list = em.createQuery("from Ong").getResultList();
        em.close();
        return list;
    }
}
