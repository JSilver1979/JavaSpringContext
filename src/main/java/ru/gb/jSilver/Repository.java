package ru.gb.jSilver;

import java.util.List;

public interface Repository {

    Product findByID(int id);

    List<Product> getAllProducts();
}
