package com.ong.dao;

import com.ong.dao.util.ConnectionFactory;
import com.ong.model.Donor;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Martins
 */
public class DonorDAO {

    public void save(Donor donor) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(donor);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void update(Donor donor) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(donor);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void remove(Donor donor) {
        EntityManager manager = ConnectionFactory.getEntityManager();

        try {
            manager.getTransaction().begin();
            Donor d = manager.find(Donor.class, donor.getCode());
            manager.remove(d);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }
    
      public Donor findById(Integer id) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            Donor d = em.find(Donor.class, id);
            return d;
        } finally {
            if (em.isOpen() && em.getTransaction().isActive()) {
                em.close();
            }
        }
    }

    public List<Donor> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Donor> list = em.createQuery("select from Donor")
                .getResultList();
        em.close();
        return list;
    }

    public List<Donor> findAll() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Donor> list = em.createQuery("from Donor").getResultList();
        em.close();
        return list;
    }
}
