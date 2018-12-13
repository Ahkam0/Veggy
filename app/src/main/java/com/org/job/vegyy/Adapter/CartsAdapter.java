package com.org.job.vegyy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.org.job.vegyy.Carts;
import com.org.job.vegyy.Item;
import com.org.job.vegyy.R;
import com.org.job.vegyy.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad Ahkam Ahmad on 7/14/2018.
 */

public class CartsAdapter extends RecyclerView.Adapter<CartsAdapter.MyViewHolder> {


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName, itemUrduName, itemPrice, itemQuantity, itemUnit;
        public ImageView itemImage,deleteImage;


        public MyViewHolder(View view) {
            super(view);

            itemName = (TextView) view.findViewById(R.id.CartItemName);
            itemUrduName = (TextView) view.findViewById(R.id.CartItemNameUrdu);
            itemPrice = (TextView) view.findViewById(R.id.CartItemNamePrice);
            itemQuantity = (TextView) view.findViewById(R.id.CartItemQuantity);
            itemUnit = (TextView)view.findViewById(R.id.CartItemPriceWithQuantity);
            itemImage = (ImageView)view.findViewById(R.id.CartItemImage);
            deleteImage = (ImageView)view.findViewById(R.id.CartDelete);

        }
    }

    public Context mContext;
    public ArrayList<Carts> arrayList;

    public CartsAdapter(Context mContext, ArrayList<Carts> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @Override
    public CartsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_layout, parent, false);
        return new CartsAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final CartsAdapter.MyViewHolder holder, final int position) {


        holder.itemName.setText(arrayList.get(position).getName());
        holder.itemUrduName.setText(arrayList.get(position).getLocalName());
        holder.itemPrice.setText("Rs."+arrayList.get(position).getPrice() + "/=");
        holder.itemQuantity.setText("Quantity - " + arrayList.get(position).getQuantity());

        if(arrayList.get(position).getUnit().equals("Kilogram")) {

            holder.itemUnit.setText("Rs."+arrayList.get(position).getPriceKG()+" - KILOGRAM");

        }

        else {

            holder.itemUnit.setText("Rs."+arrayList.get(position).getPriceGram()+" - 250 GRAM");

        }

        Glide.with(holder.itemImage.getContext())
                .load(arrayList.get(position).getImageUrl())
                .into(holder.itemImage);

        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }



}
