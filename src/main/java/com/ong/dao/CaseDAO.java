/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.dao;

import com.ong.connection.ConnectionFactory;
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
    public Case save(Case ca) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.persist(ca);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ca;
    }

    public Case update(Case ca) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.merge(ca);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ca;
    }

    public Case findById(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Case ca = null;
        try {
            ca = em.find(Case.class, id);
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ca;
    }

    public List<Case> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<Case> ca = null;

        try {
            ca = em.createQuery("from Case").getResultList();
            System.out.println(ca);
        } finally {
            em.close();
        }
        return ca;
    }

    public Case remove(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Case ca = null;
        try {
            em.getTransaction().begin();
            ca = em.find(Case.class, id);
            em.remove(ca);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ca;
    }

    public List<Case> findByName(String findById) {
        EntityManager em = ConnectionFactory.getConnection();

        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Case.class);
        Criterion c1 = Restrictions.ilike("id", findById, MatchMode.ANYWHERE);
        criteria.add(c1);
        List<Case> ca = criteria.list();
        em.close();
        return ca;
    }
}
