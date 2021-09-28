package ru.gb.spring.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductError {
    private int statusCode;
    private String message;
}
