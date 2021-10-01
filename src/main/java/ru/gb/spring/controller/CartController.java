package ru.gb.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.domain.Cart;
import ru.gb.spring.repository.CartRepository;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartRepository cartRepository;

    @GetMapping
    public ResponseEntity<Iterable<Cart>> findAll() {
        return ResponseEntity.ok(cartRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable int id) {
        Optional<Cart> maybeProduct = cartRepository.findById(id);
        if (maybeProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maybeProduct.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (cartRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cartRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<Cart> add(@RequestBody Cart cart) {
        Cart newCart = cartRepository.save(cart);
        return ResponseEntity.created(URI.create("/cart/" + newCart.getId())).body(newCart);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Cart update(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }
}