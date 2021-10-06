package ru.gb.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String password;
    @ManyToMany
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "authority"), inverseJoinColumns = @JoinColumn(name = "username"))
    private List<Authority> authorities;
}
