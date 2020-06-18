package com.ong.dao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.ong.connection.ConnectionFactory;
import com.ong.model.User;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author Martins
 */

public class UserDAO {

    public User save(User user) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

    public User update(User user) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

    public User findById(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

    public List<User> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<User> user = null;

        try {
            user = em.createQuery("from User").getResultList();
            System.out.println(user);
        } finally {
            em.close();
        }
        return user;
    }

    public User remove(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        User user = null;
        try {
            em.getTransaction().begin();
            user = em.find(User.class, id);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

    public List<User> findByName(String findByName) {
        EntityManager em = ConnectionFactory.getConnection();

        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(User.class);
        Criterion c1 = Restrictions.ilike("name", findByName, MatchMode.ANYWHERE);
        criteria.add(c1);
        List<User> user = criteria.list();
        em.close();
        return user;
    }

}
