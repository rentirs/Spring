package ru.gb.spring.repository;

import lombok.ToString;
import org.springframework.stereotype.Repository;
import ru.gb.spring.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@ToString
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>(
                List.of(
                new Product(1, "Картофель", 90.2f),
                new Product(2, "Масло", 65.5f),
                new Product(3, "Хлеб", 25.0f),
                new Product(4, "Сыр", 123.2f),
                new Product(5, "Молоко", 35.7f)
                )
        );
    }

    public Optional<Product> findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    public List<Product> findAll() {
        return products;
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void remove(int id) {
        Product product = findById(id).orElseThrow();
        this.products.remove(product);
    }
}
