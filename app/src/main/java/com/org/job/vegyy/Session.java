package com.org.job.vegyy;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Excalibur Creations on 4/6/2017.
 */

public class Session implements Serializable{

    public static Cart cart;
    public static List<Item> items;

    public Session() {
        cart = new Cart();
        items = new ArrayList<Item>();
    }

    public Session(Cart cart) {
        this.cart = cart;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        Session.items = items;
    }

    public Cart getCart() {
        return cart;
    }

    public void setBasket(Cart cart) {
        this.cart = cart;
    }

    @Nullable
    public static Item getItem(Item item) {

        for(Item i : items){
            if(i.equals(item)){
                return i;
            }
        }

        return item;
    }

    @Override
    public String toString() {
        return cart.toString();
    }
}