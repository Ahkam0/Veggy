package com.org.job.vegyy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 7/7/2018.
 */

public class Item implements Serializable {

    private String PriceKg;
    private String PriceGram;
    private String Name;
    private String LocalName;
    private String Description;
    private String imageUrl;
    private String quantity;
    private String count;
    private String category;
    private String isAdded;
    private List<String> Unit = new ArrayList<String>();

    // private String id;
    private int id;

    public Item(int id, String name,String imageUrl, int quantity, double priceKg,double priceGram, String category,String LocalName, List<String> Unit) {
        this.id = id;
        this.Name = name;
        this.imageUrl = imageUrl;
        this.quantity = String.valueOf(quantity);
        this.PriceKg = String.valueOf(priceKg);
        this.PriceGram = String.valueOf(priceGram);
        this.count = new String("0");
        this.category = category;
        this.LocalName = LocalName;
        this.Unit = Unit;

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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsAdded() {
        return isAdded;
    }

    public void setIsAdded(String isAdded) {
        this.isAdded = isAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUnit(List<String> unit) {
        Unit = unit;
    }

    public List<String> getUnit() {
        return Unit;
    }

    public String getPriceKg() {
        return PriceKg;
    }

    public void setPriceKg(String priceKg) {
        PriceKg = priceKg;
    }

    public String getPriceGram() {
        return PriceGram;
    }

    public void setPriceGram(String priceGram) {
        PriceGram = priceGram;
    }
}

