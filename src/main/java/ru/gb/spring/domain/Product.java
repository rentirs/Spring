package ru.gb.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select a from Product a"),
        @NamedQuery(name = "Product.findById", query = "select a from Product a where a.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String name;

    private float price;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
