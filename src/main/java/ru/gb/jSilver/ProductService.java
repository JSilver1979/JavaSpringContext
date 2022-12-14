package ru.gb.jSilver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private Repository repository;

    @Autowired
    private FileOutputStream out;

    public String getTitleById(Integer id) {
        return repository.findByID(id).getTitle();
    }

    public Product getProductById(Integer id) {
        return repository.findByID(id);
    }

    public void getProductList() {
        for (Product product : repository.getAllProducts()) {
            System.out.println(product.toString());
        }
    }

    public void write() throws IOException {
        out.write("Hello".getBytes(StandardCharsets.UTF_8));
        out.flush();
    }
}
