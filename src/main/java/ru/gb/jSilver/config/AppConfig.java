package ru.gb.jSilver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

@Configuration
@ComponentScan("ru.gb.jSilver")
public class AppConfig {

    @Bean
    public FileOutputStream fileOut() throws FileNotFoundException {
        return new FileOutputStream("test.txt");
    }

    @Bean
    public FileInputStream fileInput() throws FileNotFoundException {
        return new FileInputStream("test.txt");
    }

    @Bean
    public Scanner console() {
        return new Scanner(System.in);
    }

}
