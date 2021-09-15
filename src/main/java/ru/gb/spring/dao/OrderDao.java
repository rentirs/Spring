package ru.gb.spring.dao;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.gb.spring.domain.Order;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderDao {
    private final DaoSessionFactory daoSessionFactory;

    public List<Order> findAll() {
        return daoSessionFactory.findAll("Order.findAll", Order.class);
    }

    public Order findById(int id) {
        return daoSessionFactory.findById("Order.findById", id, "id", Order.class);
    }

    public void add(Order order) {
        daoSessionFactory.add(order);
    }

    public void remove(int id) {
        daoSessionFactory.remove(id, Order.class);
    }

    public void change(Order order) {
        daoSessionFactory.change(order);
    }
}
