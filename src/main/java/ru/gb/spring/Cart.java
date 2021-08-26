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
        showCart();
    }

    public void remove(int id) {
        products.stream().
                filter(product -> product.getId() == id)
                .findFirst()
                .ifPresent(products::remove);
        showCart();
    }

    public void showCart() {
        System.out.println("Содержимое корзины:");
        Set<Product> uniq = new HashSet<>(products);
        uniq.forEach(p -> System.out.println(p.getName() + " " + Collections.frequency(products, p) + "шт"));
        products.forEach(product -> sum += product.getPrice());
        System.out.println("Сумма покупок: " + sum);
        sum = 0;
    }
}
