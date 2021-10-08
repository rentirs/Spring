package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Product;
import ru.gb.spring.domain.User;
import ru.gb.spring.repository.ProductRepository;
import ru.gb.spring.repository.UserRepository;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("items", userRepository.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<User> findById(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "users-add";
    }

    @PostMapping(value = "/add")
    public String add(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/change/{id}")
    public String change(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", userRepository.findById(id));
        return "users-change";
    }

    @PostMapping(value = "/change/{id}")
    public String change(User user) {
        userRepository.save(user);
        return "redirect:/products";
    }
}

