package ru.gb.jSilver;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value="prototype")
public class Box {
    private String color;

    public Box() {
    }

    public Box(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @PostConstruct
    public void init() {
        this.color = "Yellow";
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Box{" +
                "color='" + color + '\'' +
                '}';
    }
}
