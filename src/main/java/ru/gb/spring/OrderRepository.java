package ru.gb.spring;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>(
                List.of(
                        new Order(1, LocalDate.now(), 888.77F, Collections.emptyList()))
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

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
