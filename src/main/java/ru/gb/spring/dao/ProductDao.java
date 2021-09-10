package ru.gb.spring.dao;

import lombok.ToString;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.gb.spring.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@ToString
public class ProductDao {
    final EntityManagerFactory factory = new Configuration().configure().buildSessionFactory();
    EntityManager entityManager;

    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Product> products = entityManager.createQuery("select pr from Product as pr", Product.class).getResultList();
        entityManager.getTransaction().commit();
        return products;
    }

    public void add(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public void remove(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    public void change(Product product) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Product set name = :title, price = :price where id = :id")
                .setParameter("id", product.getId())
                .setParameter("title", product.getName())
                .setParameter("price", product.getPrice())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
