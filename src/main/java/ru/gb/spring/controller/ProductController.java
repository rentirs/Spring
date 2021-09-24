package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Product;
import ru.gb.spring.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private int page = 1;

    @GetMapping
    public String findTen(Model model) {
        int quantity = (int) productRepository.count();
        int pages = (quantity%10 == 0) ? quantity/10 : quantity/10 + 1;
        model.addAttribute("items", productRepository.findProductsByIdBetween(page * 10 - 9, page * 10));
        model.addAttribute("pages", pages);
        model.addAttribute("curPage", page);
        return "products";
    }

    @GetMapping("/step/{step}")
    public String nextPage(@PathVariable int step) {
        page = page + step;
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Product> findById(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
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
    public String change(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "products-change";
    }

    @PostMapping(value = "/change/{id}")
    public String change(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping(value = "/expensively/{priceMin}")
    @ResponseBody
    public List<Product> findProductsByPriceAfter(@PathVariable("priceMin") float priceMin) {
        List<Product> products = new ArrayList<>();
        productRepository.findProductsByPriceAfter(priceMin).forEach(products::add);
        return products;
    }

    @GetMapping(value = "/cheaper/{priceMax}")
    @ResponseBody
    public List<Product> findProductsByPriceBefore(@PathVariable("priceMax") float priceMax) {
        List<Product> products = new ArrayList<>();
        productRepository.findProductsByPriceBefore(priceMax).forEach(products::add);
        return products;
    }

    @GetMapping(value = "/between/{priceMin}/{priceMax}")
    @ResponseBody
    public List<Product> findProductsByPriceAfter(@PathVariable("priceMin") float priceMin, @PathVariable("priceMax") float priceMax) {
        List<Product> products = new ArrayList<>();
        productRepository.findProductsByPriceBetween(priceMin, priceMax).forEach(products::add);
        return products;
    }
}