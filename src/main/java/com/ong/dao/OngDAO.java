/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.dao;

import com.ong.connection.ConnectionFactory;
import com.ong.model.Ong;
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
public class OngDAO {
    public Ong save(Ong ong) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.persist(ong);
            em.getTransaction().commit();
        } catch (Exception e) {
           
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ong;
    }

    public Ong update(Ong ong) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.merge(ong);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ong;
    }

    public Ong findById(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Ong ong = null;
        try {
            ong = em.find(Ong.class, id);
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ong;
    }

    public List<Ong> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<Ong> ong = null;

        try {
            ong = em.createQuery("from Ong").getResultList();
            System.out.println(ong);
        } finally {
            em.close();
        }
        return ong;
    }

    public Ong remove(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Ong ong = null;
        try {
            em.getTransaction().begin();
            ong = em.find(Ong.class, id);
            em.remove(ong);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ong;
    }

    public List<Ong> findByName(String findByName) {
        EntityManager em = ConnectionFactory.getConnection();

        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Ong.class);
        Criterion c1 = Restrictions.ilike("name", findByName, MatchMode.ANYWHERE);
        criteria.add(c1);
        List<Ong> ong = criteria.list();
        em.close();
        return ong;
    }
}
