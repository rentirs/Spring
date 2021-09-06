package ru.gb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.Product;
import ru.gb.spring.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public String findAll(Model model){
        model.addAttribute("products", repository.findAll());
        return "products";
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable String id){
    }

    @GetMapping(value = "/products/add")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @PostMapping(value = "/products/add")
    public String add(Product product) {
        repository.add(product);
        return "redirect:/products";
    }
}
