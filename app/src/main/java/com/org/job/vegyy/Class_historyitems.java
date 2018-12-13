package com.org.job.vegyy;

public class Class_historyitems {
    public String name;
    public String price;
    public String quantity;


    public Class_historyitems(String name, String price, String quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
