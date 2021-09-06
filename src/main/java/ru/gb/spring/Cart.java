package ru.gb.spring;

import java.util.*;

public class Cart {
    private final ProductRepository repository;
    private final List<Product> products;
    double sum = 0;

    public Cart(ProductRepository repository) {
        this.repository = repository;
        this.products = new ArrayList<>();
    }

    public void add(int id) {
        repository.findById(id).ifPresent(products::add);
    }

//    public void remove(int id) {
//        products.stream().
//                filter(p -> p.getId() == id)
//                .findFirst()
//                .ifPresent(products::remove);
//    }
}
