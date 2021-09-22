package ru.gb.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.spring.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findProductsByPriceAfter(float priceMin);
    Iterable<Product> findProductsByPriceBefore(float priceMax);
    Iterable<Product> findProductsByPriceBetween(float priceMin, float priceMax);
}
