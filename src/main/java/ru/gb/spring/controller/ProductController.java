package ru.gb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Product;
import ru.gb.spring.dao.ProductDao;

@Controller
public class ProductController {

    private final ProductDao repository;

    public ProductController(ProductDao repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public String findAll(Model model) {
        model.addAttribute("items", repository.findAll());
        return "products";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product findById(@PathVariable int id){
        return repository.findById(id);
    }

    @GetMapping(value = "/products/delete/{id}")
    public String delete(@PathVariable("id") int id){
        repository.remove(id);
        return "redirect:/products";
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

    @GetMapping(value = "/products/change/{id}")
    public String change(@PathVariable("id") int id, Model model){
        model.addAttribute("product", repository.findById(id));
        return "products-change";
    }

    @PostMapping(value = "/products/change/{id}")
    public String change(Product product) {
        repository.change(product);
        return "redirect:/products";
    }
}
