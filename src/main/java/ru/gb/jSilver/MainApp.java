package ru.gb.jSilver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.jSilver.config.AppConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MainApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean(ProductService.class);
        System.out.println(productService.getTitleById(4));
        productService.write();

//        FileInputStream is = context.getBean(FileInputStream.class);
//        System.out.println(is);

//        FileOutputStream out = context.getBean(FileOutputStream.class);
//        out.write(productService.getTitleById(4).getBytes(StandardCharsets.UTF_8));
//        out.flush();


    }
}