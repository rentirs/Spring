package ru.gb.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.spring.domain.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
