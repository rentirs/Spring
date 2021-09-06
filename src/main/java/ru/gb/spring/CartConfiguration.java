package ru.gb.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CartConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public Cart cart(ProductRepository repository) {
        return new Cart(repository);
    }

    @Bean
    OrderRepository orderRepository() {
        return new OrderRepository();
    }
}
