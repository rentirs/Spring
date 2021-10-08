package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Product;
import ru.gb.spring.repository.ProductRepository;

import java.util.Optional;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("items", productRepository.findAll());
        return "products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Product> findById(@PathVariable long id) {
        return productRepository.findById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @PostMapping(value = "/add")
    public String add(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping(value = "/change/{id}")
    public String change(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "products-change";
    }

    @PostMapping(value = "/change/{id}")
    public String change(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }
}

