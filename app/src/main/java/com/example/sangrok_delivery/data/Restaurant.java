package com.example.sangrok_delivery.data;

public class Restaurant {

    public Restaurant(String name, String location){
        this.name = name;
        this.location = location;
    }

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
