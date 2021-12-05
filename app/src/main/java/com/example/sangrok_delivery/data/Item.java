package com.example.sangrok_delivery.data;

public class Item {
    public Item(String name, Integer number){
        this.name = name;
        this.number = number;
    }

    private String name;
    private Integer number;

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }
}
