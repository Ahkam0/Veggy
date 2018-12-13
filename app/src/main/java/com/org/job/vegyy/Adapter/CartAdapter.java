package com.org.job.vegyy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.org.job.vegyy.Item;
import com.org.job.vegyy.R;
import com.org.job.vegyy.Session;

import java.util.List;

/**
 * Created by Excalibur Creations on 24-Apr-17.
 */

public class CartAdapter extends ArrayAdapter<Item>{

    List<Item> cartItems;
    Context context;

    public CartAdapter(@NonNull Context context, @NonNull List<Item> cartItems) {
        super(context, 0, cartItems);
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        }

        TextView textViewItemName = (TextView)convertView.findViewById(R.id.textViewItemName);
        TextView textViewItemQuantity = (TextView)convertView.findViewById(R.id.textViewItemQuantity);
        TextView textViewItemPrice = (TextView)convertView.findViewById(R.id.textViewItemPrice);

        Item item = Session.cart.getItems().get(position);

        textViewItemName.setText(item.getName());
        textViewItemQuantity.setText(String.valueOf(item.getCount()));
        textViewItemPrice.setText(String.valueOf(item.getPriceKg()));

        return convertView;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }
}