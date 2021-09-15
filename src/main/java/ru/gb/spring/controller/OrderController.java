package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Order;
import ru.gb.spring.dao.OrderDao;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDao orderDao;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("orders", orderDao.findAll());
        return "orders";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order findById(@PathVariable int id){
        return orderDao.findById(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        orderDao.remove(id);
        return "redirect:/orders";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("order", new Order());
        return "orders-add";
    }

    @PostMapping("/add")
    public String add(Order order) {
        orderDao.add(order);
        return "redirect:/orders";
    }
}
