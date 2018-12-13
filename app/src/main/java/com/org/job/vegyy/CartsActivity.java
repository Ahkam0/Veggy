package com.org.job.vegyy;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.org.job.vegyy.Adapter.CartsAdapter;
import com.org.job.vegyy.Adapter.ItemAdapter;
import com.org.job.vegyy.Model.ModelShowCard;
import com.org.job.vegyy.Model.ModelShowItems;
import com.org.job.vegyy.Utilities.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartsActivity extends AppCompatActivity {

    ApiUtils apiUtils;

    TextView totalitems,totalprice,grandtotalprice;

    RecyclerView recyclerView;

    ArrayList<Carts> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carts);

        totalitems = (TextView)findViewById(R.id.totalitems);
        totalprice = (TextView)findViewById(R.id.totalprice);
        grandtotalprice = (TextView)findViewById(R.id.grandtotalPrice);

        recyclerView = (RecyclerView) findViewById(R.id.cartList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(CartsActivity.this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        showCards();


    }


    public void showCards() {

        apiUtils.getSOService().getcards(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID)).enqueue(new Callback<ModelShowCard>() {

            @Override
            public void onResponse(Call<ModelShowCard> call, Response<ModelShowCard> response) {

                ModelShowCard modelShowCard;
                if (response.isSuccessful()) {
                    modelShowCard = response.body();

                    for (int indx = 0; indx < modelShowCard.getStatus().size() ; indx++) {

                        arrayList.add(new Carts(Integer.valueOf(modelShowCard.getStatus().get(indx).getItemId()),modelShowCard.getStatus().get(indx).getName(),modelShowCard.getStatus().get(indx).getImage(),modelShowCard.getStatus().get(indx).getQuantity(),modelShowCard.getStatus().get(indx).getPrice(),modelShowCard.getStatus().get(indx).getPriceKG(),modelShowCard.getStatus().get(indx).getPriceGRAM(),modelShowCard.getStatus().get(indx).getUrduName(),modelShowCard.getStatus().get(indx).getUnit()));

                    }

                    CartsAdapter cartsAdapter = new CartsAdapter(CartsActivity.this,arrayList);
                    recyclerView.setAdapter(cartsAdapter);

                    totalitems.setText(modelShowCard.getTotalitems() + " Items");
                    totalprice.setText("Rs."+ modelShowCard.getTotal() + "/=");
                    grandtotalprice.setText("Rs." + modelShowCard.getGrandtotal() + "/=");


                } else {
                    Toast.makeText(CartsActivity.this, "Try AGAIN", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelShowCard> call, Throwable t) {

                Toast.makeText(CartsActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
