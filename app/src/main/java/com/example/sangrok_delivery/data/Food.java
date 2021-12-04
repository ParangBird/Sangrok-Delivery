package com.example.sangrok_delivery.data;

public class Food {
    public Food(String name, String price){
        this.name = name;
        this.price = price;
    }

    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
