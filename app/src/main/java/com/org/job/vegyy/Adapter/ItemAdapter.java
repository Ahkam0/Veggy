package com.org.job.vegyy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.provider.Settings;
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
import com.org.job.vegyy.Item;
import com.org.job.vegyy.ItemsActivity;
import com.org.job.vegyy.Model.ModelAddtoCart;
import com.org.job.vegyy.Model.ModelShowItems;
import com.org.job.vegyy.R;
import com.org.job.vegyy.Session;
import com.org.job.vegyy.Utilities.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Muhammad Ahkam Ahmad on 7/14/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    ApiUtils apiUtils;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName, itemUrduName, itemPrice, itemQuantity;
        public ImageView itemImage, add, remove;

        public Spinner itemPriceWithQuantity;

        public Button addToCard;


        public MyViewHolder(View view) {
            super(view);

            itemImage = (ImageView) view.findViewById(R.id.ItemImage);
            add = (ImageView) view.findViewById(R.id.Add);
            remove = (ImageView) view.findViewById(R.id.Remove);

            itemName = (TextView) view.findViewById(R.id.ItemName);
            itemUrduName = (TextView) view.findViewById(R.id.ItemNameUrdu);
            itemPrice = (TextView) view.findViewById(R.id.ItemNamePrice);
            itemQuantity = (TextView) view.findViewById(R.id.ItemQuantity);
            itemPriceWithQuantity = (Spinner) view.findViewById(R.id.ItemPriceWithQuantity);

            addToCard = (Button)view.findViewById(R.id.AddtoCard);

        }
    }

    public Context mContext;
    public ArrayList<Item> arrayList;

    public ItemAdapter(Context mContext, ArrayList<Item> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ItemAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final ItemAdapter.MyViewHolder holder, final int position) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.mContext,android.R.layout.simple_spinner_dropdown_item,arrayList.get(position).getUnit());

        final String pricekg = arrayList.get(position).getPriceKg();

        final String pricegram = arrayList.get(position).getPriceGram();


        holder.itemName.setText(arrayList.get(position).getName());
        holder.itemUrduName.setText(arrayList.get(position).getLocalName());
        holder.itemPrice.setText("Rs."+arrayList.get(position).getPriceKg() + "/=");
        holder.itemPriceWithQuantity.setAdapter(adapter);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double price=0;

                int quantity = Integer.valueOf(arrayList.get(position).getQuantity());
                Log.d("a", String.valueOf(quantity));

                arrayList.get(position).setQuantity(String.valueOf(Integer.valueOf(arrayList.get(position).getQuantity()) + 1));
                holder.itemQuantity.setText(String.valueOf(arrayList.get(position).getQuantity()));

                Session.setItems(arrayList);
                Log.d("AD", Session.getItems().toString());

//                if(holder.itemPriceWithQuantity.getSelectedItem().toString().contains("KILOGRAM"))
//                {
//                    price = Double.valueOf(holder.itemQuantity.getText().toString()) * Double.valueOf(arrayList.get(position).getPriceKg());
//                } else {
//                    price = Double.valueOf(holder.itemQuantity.getText().toString()) * Double.valueOf(arrayList.get(position).getPriceGram());
//                }
//
//                holder.itemPrice.setText(String.valueOf("Rs."+String.valueOf(price) + "/="));
            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double price=0;

                int quantity = Integer.valueOf(arrayList.get(position).getQuantity());
                if (quantity <= 0) {

                } else {
                    arrayList.get(position).setQuantity(String.valueOf(Integer.valueOf(arrayList.get(position).getQuantity()) - 1));
                    holder.itemQuantity.setText(String.valueOf(arrayList.get(position).getQuantity()));
                }

                Session.setItems(arrayList);
                Log.d("RM", Session.getItems().toString());

//                if(holder.itemPriceWithQuantity.getSelectedItem().toString().contains("KILOGRAM"))
//                {
//                    price = Double.valueOf(holder.itemQuantity.getText().toString()) * Double.valueOf(arrayList.get(position).getPriceKg());
//                } else {
//                    price = Double.valueOf(holder.itemQuantity.getText().toString()) * Double.valueOf(arrayList.get(position).getPriceGram());
//                }
//
//                holder.itemPrice.setText(String.valueOf("Rs."+String.valueOf(price) + "/="));

            }
        });


        holder.addToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String finalpricekg = String.valueOf(Double.valueOf(pricekg) * Double.valueOf(holder.itemQuantity.getText().toString()));

                String finalpricegram = String.valueOf(Double.valueOf(pricegram) * Double.valueOf(holder.itemQuantity.getText().toString()));


                if (holder.itemPriceWithQuantity.getSelectedItem().toString().contains("KILOGRAM")) {

                    addToCart(String.valueOf(arrayList.get(position).getId()), Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID),finalpricekg,holder.itemQuantity.getText().toString(),"Kilogram");

                } else {


                    addToCart(String.valueOf(arrayList.get(position).getId()), Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID),finalpricegram,holder.itemQuantity.getText().toString(),"250 Gram");


                }


            }
        });



       holder.itemPriceWithQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               if (holder.itemPriceWithQuantity.getSelectedItem().toString().contains("KILOGRAM")) {

                   holder.itemPrice.setText("Rs." + pricekg + "/=");

               } else {

                   holder.itemPrice.setText("Rs." + pricegram + "/=");
               }


           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {


           }
       });


        Glide.with(holder.itemImage.getContext())
                .load(arrayList.get(position).getImageUrl())
                .into(holder.itemImage);


    }




    public void addToCart(String item_id,String mobile_id ,String price,String quantity,String unit) {

        apiUtils.getSOService().addtocart(item_id, mobile_id , price, quantity, unit).enqueue(new Callback<ModelAddtoCart>() {

            @Override
            public void onResponse(Call<ModelAddtoCart> call, Response<ModelAddtoCart> response) {

                ModelAddtoCart modelShowItems;
                if (response.isSuccessful()) {
                    modelShowItems = response.body();

                    Toast.makeText(mContext, "Added to Card", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(mContext, "Try AGAIN", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelAddtoCart> call, Throwable t) {

                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }





    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
