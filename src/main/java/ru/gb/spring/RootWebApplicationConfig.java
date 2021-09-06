package ru.gb.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CartConfiguration.class)
public class RootWebApplicationConfig {
}
