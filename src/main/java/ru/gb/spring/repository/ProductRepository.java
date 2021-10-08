package ru.gb.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.spring.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
