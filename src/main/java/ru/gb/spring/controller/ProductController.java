package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Product;
import ru.gb.spring.dao.ProductDao;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductDao productDao;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("items", productDao.findAll());
        return "products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product findById(@PathVariable int id){
        return productDao.findById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        productDao.remove(id);
        return "redirect:/products";
    }

    @GetMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @PostMapping(value = "/add")
    public String add(Product product) {
        productDao.add(product);
        return "redirect:/products";
    }

    @GetMapping(value = "/change/{id}")
    public String change(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productDao.findById(id));
        return "products-change";
    }

    @PostMapping(value = "/change/{id}")
    public String change(Product product) {
        productDao.change(product);
        return "redirect:/products";
    }
}
