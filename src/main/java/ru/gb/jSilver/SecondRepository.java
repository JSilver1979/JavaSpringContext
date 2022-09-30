package ru.gb.jSilver;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecondRepository implements Repository{
    @Override
    public Product findByID(int id) {
        throw new RuntimeException("SecondRepository not for use in homework 2");
    }

    @Override
    public List<Product> getAllProducts() {
        throw new RuntimeException("SecondRepository not for use in homework 2");
    }
}
