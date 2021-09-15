package ru.gb.spring.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class DaoSessionFactory {

    private EntityManagerFactory factory;

    public DaoSessionFactory() {
        factory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public <T> List<T> findAll(String str, Class<T> cls) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<T> list = entityManager.createNamedQuery(str, cls).getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    public <T> T findById(String str, int id, String parameter, Class<T> cls) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        T t = entityManager.createNamedQuery(str, cls)
                .setParameter(parameter, id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return t;
    }

    public <T> void add(T t) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public <T> void remove(int id, Class<T> cls) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(cls, id));
        entityManager.getTransaction().commit();
    }

    public <T> void change(T t) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
    }
}
