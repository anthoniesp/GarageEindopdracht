package com.example.garageeindopdracht.Models;

public class Part {
    private String name;
    private int price;

    public Part(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
