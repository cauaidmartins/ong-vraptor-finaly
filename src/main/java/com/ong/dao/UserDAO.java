package com.ong.dao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.ong.dao.util.ConnectionFactory;
import com.ong.model.User;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author Martins
 */

public class UserDAO {

    public void save(User user) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void update(User user) {
        EntityManager manager = ConnectionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }

    public void remove(User user) {
        EntityManager manager = ConnectionFactory.getEntityManager();

        try {
            manager.getTransaction().begin();
            User u = manager.find(User.class, user.getCode());
            manager.remove(u);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager.isOpen() && manager.getTransaction().isActive()) {
                manager.close();
            }
        }
    }
    
      public User findById(Integer id) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            User u = em.find(User.class, id);
            return u;
        } finally {
            if (em.isOpen() && em.getTransaction().isActive()) {
                em.close();
            }
        }
    }

    public List<User> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<User> list = em.createQuery("select c from User o where lower(.name) like lower(:name)", User.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.close();
        return list;
    }

    public List<User> findAll() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<User> list = em.createQuery("from User", User.class).getResultList();
        em.close();
        return list;
    }
}
