package ru.gb.spring;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private  int id;
    private LocalDate date;
    private float cost;
    private List<Product> products;

    public Order() {
    }

    public Order(int id, LocalDate date, float cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getCost() {
        return cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}
