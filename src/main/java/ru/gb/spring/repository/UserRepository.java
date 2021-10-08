package ru.gb.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.spring.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
