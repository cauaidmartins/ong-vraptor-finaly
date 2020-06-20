/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.dao;

import com.ong.dao.util.ConnectionFactory;
import com.ong.model.Case;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lucas Rasec
 */
public class CaseDAO {
  
    public void save(Case ca) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(ca);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void update(Case ca) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(ca);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void remove(Case ca) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            Case c = manager.find(Case.class, ca.getCode());
            manager.remove(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }
    
      public Case findById(Integer id) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            Case ca = em.find(Case.class, id);
            return ca;
        } finally {
            if (em.isOpen() && em.getTransaction().isActive()) {
                em.close();
            }
        }
    }

    public List<Case> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Case> list = em.createQuery("select c from Ong o where lower(.name) like lower(:name)", Case.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.close();
        return list;
    }

    public List<Case> findAll() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Case> list = em.createQuery("from Case", Case.class).getResultList();
        em.close();
        return list;
    }
}
