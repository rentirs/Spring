package ru.gb.spring.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import ru.gb.spring.domain.Product;
import ru.gb.spring.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ProductControllerTest {

    private Product product = new Product(1L, "fwef", 12);

    @Test
    void findAll() {
        ProductRepository productRepository = mock(ProductRepository.class);
        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
        ProductController productController = new ProductController(productRepository);
        Assertions.assertThat(productController.findAll(mock(Model.class))).isNotEmpty();
    }

    @Test
    void findById() {
        ProductRepository productRepository = mock(ProductRepository.class);
        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
        ProductController productController = new ProductController(productRepository);
        Assertions.assertThat(productController.findById(1L).equals(product));
    }
}