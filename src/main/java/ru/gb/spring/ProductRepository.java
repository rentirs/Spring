package ru.gb.spring;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        this.products = List.of(
                new Product(1, "Картофель", 90.2),
                new Product(2, "Масло", 65.5),
                new Product(3, "Хлеб", 25.0),
                new Product(4, "Сыр", 123.2),
                new Product(5, "Молоко", 35.7)
        );
    }

    public Optional<Product> findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    public List<Product> findAll() {
        return products;
    }
}
