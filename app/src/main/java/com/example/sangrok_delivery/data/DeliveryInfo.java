package com.example.sangrok_delivery.data;

public class DeliveryInfo {
    private String where;
    private String endtime;
    private String message;
    private String menus;
    private String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public DeliveryInfo(String where, String endtime, String message, String menus, String destination) {
        this.where = where;
        this.endtime = endtime;
        this.message = message;
        this.menus = menus;
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
