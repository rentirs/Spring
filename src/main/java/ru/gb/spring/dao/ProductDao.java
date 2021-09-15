package ru.gb.spring.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.spring.domain.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDao {
    private final DaoSessionFactory daoSessionFactory;

    public List<Product> findAll() {
        return daoSessionFactory.findAll("Product.findAll", Product.class);
    }

    public Product findById(int id) {
        return daoSessionFactory.findById("Product.findById", id, "id", Product.class);
    }

    public void add(Product product) {
        daoSessionFactory.add(product);
    }

    public void remove(int id) {
        daoSessionFactory.remove(id, Product.class);
    }

    public void change(Product product) {
        daoSessionFactory.change(product);
    }
}
