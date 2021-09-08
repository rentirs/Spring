package ru.gb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.spring.domain.Product;
import ru.gb.spring.repository.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
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
        return repository.findById(id).orElseThrow();
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
}
