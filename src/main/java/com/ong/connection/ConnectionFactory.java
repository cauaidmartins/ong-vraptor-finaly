package com.ong.connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ong");

    private ConnectionFactory() {
    }

    public static EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
