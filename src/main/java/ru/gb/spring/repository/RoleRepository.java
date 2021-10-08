package ru.gb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
