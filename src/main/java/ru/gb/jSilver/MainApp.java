package ru.gb.jSilver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.jSilver.config.AppConfig;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean(ProductService.class);
        Cart cart = context.getBean(Cart.class);
        Scanner console = context.getBean(Scanner.class);
        
        boolean isShopping = true;
        
        System.out.println("List of products:");
        System.out.println("*****************");
        productService.getProductList();
        System.out.println("*****************");
        while (isShopping) {
            System.out.println("If you want to add product to cart, enter \"add [id number]\"");
            System.out.println("If you want to remove product to cart, enter \"rm [id number]\"");
            System.out.println("If you want to list products in cart, enter \"list\"");
            System.out.println("To exit from shop, enter \"exit\"");
            
            String[] input = console.nextLine().split(" ",3);
            
            if (input[0].contains("add")) {
                try {
                    cart.addProductToCart(productService.getProductById(Integer.valueOf(input[1])));
                } catch (NoSuchElementException err) {
                    System.out.println("No products with id [" + input[1] + "] in the shop!");
                } catch (NumberFormatException err) {
                    System.out.println("No such products in the shop!");
                }
            } else if (input[0].contains("rm")) {
                try {
                    cart.removeProductFromCart((Integer.valueOf(input[1])));
                } catch (NumberFormatException err) {
                    System.out.println("No such products in the cart!");
                }
            } else if (input[0].contains("list")) {
                cart.listCartProducts();
            } else if (input[0].contains("exit")) {
                isShopping = false;
            } else {
                System.out.println("Please, enter command");
            }

        }
        console.close();
    }
}