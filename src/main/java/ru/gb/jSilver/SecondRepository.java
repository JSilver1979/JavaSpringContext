package ru.gb.jSilver;

import org.springframework.stereotype.Component;

@Component
public class SecondRepository implements Repository{
    @Override
    public Product findByID(int id) {
        throw new RuntimeException("Second Repo was chosen");
    }
}
