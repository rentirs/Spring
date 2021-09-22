package ru.gb.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.spring.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
