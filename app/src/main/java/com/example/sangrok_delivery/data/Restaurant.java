package com.example.sangrok_delivery.data;

public class Restaurant {

    public Restaurant(String name, String location, int src){
        this.name = name;
        this.location = location;
        this.image_src = src;
    }

    private String name;
    private String location;
    private int image_src;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage_src() {
        return image_src;
    }

    public void setImage_src(int image_src) {
        this.image_src = image_src;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
