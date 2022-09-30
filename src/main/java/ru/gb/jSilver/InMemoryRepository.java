package ru.gb.jSilver;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(value="trueRepo")
@Primary
public class InMemoryRepository implements Repository{

    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1,"Apple",100.3),
                new Product(2,"Orange",200.0),
                new Product(3,"Carrot",50.5),
                new Product(4,"Pumpkin",150.7),
                new Product(5,"Tomato",220.0),
                new Product(6,"Cucumber",199.9),
                new Product(7,"Potato",10.9)
        ));
    }

    @Override
    public Product findByID(int id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }

}
