package ru.gb.spring.dao;

import lombok.ToString;
import org.springframework.stereotype.Repository;
import ru.gb.spring.domain.Order;

import java.text.SimpleDateFormat;
import java.util.*;

@ToString
@Repository
public class OrderRepository {
    private final List<Order> orders;
    final Date date = new Date();
    final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    final String dateString = formatter.format(date);

    public OrderRepository() {
        this.orders = new ArrayList<>(
                List.of(
                        new Order(1, dateString, 888.77F, Collections.emptyList()))
        );
    }

    public Optional<Order> findById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst();
    }

    public List<Order> findAll() {
        return orders;
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    public void remove(int id) {
        Order order = findById(id).orElseThrow();
        this.orders.remove(order);
    }
}
