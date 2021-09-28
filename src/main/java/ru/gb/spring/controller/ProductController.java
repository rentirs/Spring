package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Product;
import ru.gb.spring.error.ProductError;
import ru.gb.spring.repository.ProductRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> maybeProduct = productRepository.findById(id);
        if (maybeProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maybeProduct.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (productRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product newProduct = productRepository.save(product);
        return ResponseEntity.created(URI.create("/products/" + newProduct.getId())).body(newProduct);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product update(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/expensively/{priceMin}")
    public ResponseEntity<Iterable<Product>> findProductsByPriceAfter(@PathVariable("priceMin") float priceMin) {
        return ResponseEntity.ok(productRepository.findProductsByPriceAfter(priceMin));
    }

    @GetMapping("/cheaper/{priceMax}")
    public ResponseEntity<Iterable<Product>> findProductsByPriceBefore(@PathVariable("priceMax") float priceMax) {
        return ResponseEntity.ok(productRepository.findProductsByPriceBefore(priceMax));
    }

    @GetMapping("/between/{priceMin}/{priceMax}")
    public ResponseEntity<Iterable<Product>> findProductsByPriceAfter(@PathVariable("priceMin") float priceMin, @PathVariable("priceMax") float priceMax) {
        return ResponseEntity.ok(productRepository.findProductsByPriceBetween(priceMin, priceMax));
    }

    @ExceptionHandler
    public ResponseEntity<ProductError> handleException(RuntimeException ex) {
        return ResponseEntity.internalServerError()
                .body(new ProductError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }
}