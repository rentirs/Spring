package ru.gb.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select a from Order a"),
        @NamedQuery(name = "Order.findById", query = "select a from Order a where a.id = :id")
})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    private float cost;

//    private List<Product> products;

    public Order(String date, float cost) {
        this.date = date;
        this.cost = cost;
    }
}
