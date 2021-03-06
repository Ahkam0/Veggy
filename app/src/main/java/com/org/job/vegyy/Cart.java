package com.org.job.vegyy;
import com.org.job.vegyy.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Excalibur Creations on 4/6/2017.
 */

public class Cart {

    public static List<Item> items;
    public static double total;


    public Cart() {
        items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return this.items;
    }


    public Item getItem(Item item) {
        if (items.contains(item)) {
            for (Item i : items) {
                if (i.getName().equals(item.getName())) {
                    return item;
                }
            }
        } else {
            return null;
        }

        return item;
    }

    public void addItems(Item item) {
        if (items.contains(item)) {
            for (int i = 0; i < items.size(); i++) {
                Item temp = items.get(i);
                if (temp.getName().equals(item.getName())) {
                    int count = Integer.valueOf(temp.getCount());
                    temp.setCount(String.valueOf(count));
                }
            }
        } else {
            items.add(item);
        }

    }

    public Item removeItem(Item item) {
        if (items.contains(item)) {
            for (int i = 0; i < items.size(); i++) {
                Item temp = items.get(i);
                if (temp.getName().equals(item.getName())) {
                    items.remove(i);
                }
            }
        } else {
            return null;
        }
        return item;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return items + " : " + total;
    }
}