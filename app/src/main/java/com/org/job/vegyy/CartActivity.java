package com.org.job.vegyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.org.job.vegyy.Adapter.CartAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements Serializable {

    private static final String TAG = CartActivity.class.getSimpleName();
    String[] basket;
    private int total = 0;
    Button btnFinalizeOrder;
    TextView txtBasketTotal;
    //ArrayAdapter<String> adapter;
    CartAdapter adapter;
    List<Item> itemList = new ArrayList<Item>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listView = (ListView) findViewById(R.id.items_list);

        if (Session.cart.getItems() != null) {
            itemList = loadData();
        }
        Log.d(TAG, itemList.toString());
        /*
        List<String> items = new ArrayList<String>();
        if (itemList != null) {



            for(Item i : itemList){
                items.add(i.getName());
            }


            adapter = new ArrayAdapter<String>(this, R.layout.listview_item, items);
            listView.setAdapter(adapter);

        } else {

        }

*/
        adapter = new CartAdapter(this, Session.cart.getItems());
        listView.setAdapter(adapter);
        txtBasketTotal = (TextView) findViewById(R.id.txtCartTotal);


        btnFinalizeOrder = (Button) findViewById(R.id.btnFinalizeOrder);
        btnFinalizeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(CartActivity.this, LoginActivity.class);
                startActivity(intent);*/
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               /* if(Session.cart.getItems() != null && Session.cart.getItems().size() > 0) {
                    Intent intent = new Intent(CartActivity.this, SelectedItemActivity.class);
                    intent.putExtra("position", i);
                    Log.d(TAG, Session.getItems().toString());
                    startActivity(intent);
                }*/
            }
        });


    }


    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "On restart");
        itemList = Session.cart.getItems();
        adapter.notifyDataSetChanged();
        Log.d(TAG, itemList.toString());

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "On Resume");
        itemList = Session.cart.getItems();
        updateData();
        adapter.notifyDataSetChanged();
        Log.d(TAG, itemList.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                // adapter.notifyDataSetChanged();
            }
            if (resultCode == RESULT_CANCELED) {

            }
        }
    }

    public List<Item> loadData() {

        for (Item i : Session.items) {
            int count = Integer.valueOf(i.getQuantity());
            if (count > 0) {
                Session.cart.addItems(i);
            }
        }
        return Session.cart.getItems();
    }

    public void updateData() {
        total = 0;
        for (int i = 0; i < itemList.size(); i++) {
            basket = new String[itemList.size()];
            basket[i] = itemList.get(i).getName();
            total += Double.valueOf(itemList.get(i).getPriceKg()) * Double.valueOf(itemList.get(i).getQuantity());
            Log.d(TAG, String.valueOf(total));
            txtBasketTotal.setText(String.valueOf(total));
            Session.cart.setTotal(total);

        }
    }
}