package com.org.job.vegyy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad Ahkam Ahmad on 7/31/2018.
 */

public class Carts implements Serializable {

    private int id;
    private String Name;
    private String LocalName;
    private String imageUrl;
    private String quantity;
    private String Price;
    private String PriceKG;
    private String PriceGram;
    private String Unit;

    public Carts(int id, String name, String imageUrl, String quantity, String price,String pricekg,String pricegram, String LocalName, String unit) {
        this.id = id;
        this.Name = name;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.Price = price;
        this.PriceKG = pricekg;
        this.PriceGram = pricegram;
        this.LocalName = LocalName;
        this.Unit = unit;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String localName) {
        LocalName = localName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }


    public String getPriceKG() {
        return PriceKG;
    }

    public void setPriceKG(String priceKG) {
        PriceKG = priceKG;
    }

    public String getPriceGram() {
        return PriceGram;
    }

    public void setPriceGram(String priceGram) {
        PriceGram = priceGram;
    }
}