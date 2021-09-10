package ru.gb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Order;
import ru.gb.spring.dao.OrderRepository;

@Controller
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    public String findAll(Model model) {
        model.addAttribute("orders", repository.findAll());
        return "orders";
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order findById(@PathVariable int id){
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/orders/delete/{id}")
    public String delete(@PathVariable("id") int id){
        repository.remove(id);
        return "redirect:/orders";
    }

    @GetMapping("/orders/add")
    public String add(Model model) {
        model.addAttribute("order", new Order());
        return "orders-add";
    }

    @PostMapping("/orders/add")
    public String add(Order order) {
        repository.add(order);
        return "redirect:/orders";
    }
}
