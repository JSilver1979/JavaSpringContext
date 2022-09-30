package ru.gb.jSilver;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Scope(value="prototype")
public class Cart {
    private List<Product> cartProductList;

    @PostConstruct
    public void init() {
        this.cartProductList = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        System.out.println(product.getTitle() + " added to cart");
        cartProductList.add(product);
    }

    public void removeProductFromCart(int id) {
        try {
            Product removingProduct = cartProductList.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
            cartProductList.remove(removingProduct);
            System.out.println(removingProduct.getTitle() + " removed from cart");
        } catch (NoSuchElementException e) {
            System.out.println("No product with id [" + id + "] found in cart");
        } catch (NumberFormatException err) {
            System.out.println("No such products in the cart!");
        }
    }

    public void listCartProducts() {
        System.out.println("Cart has products:");
        System.out.println("------------------");
        for (Product p : cartProductList) {
            System.out.println(p.toString());
        }
        System.out.println("------------------");
    }
}
