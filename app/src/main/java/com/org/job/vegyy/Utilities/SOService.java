package com.org.job.vegyy.Utilities;

import com.org.job.vegyy.Model.ModelAddtoCart;
import com.org.job.vegyy.Model.ModelShowCard;
import com.org.job.vegyy.Model.ModelShowItems;
import com.org.job.vegyy.Model.ModelSignUp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface  SOService {

    @GET("Items/showitems.php")
    Call<ModelShowItems> getItems(@Query("category") String category);

    @GET("Cards/showcard.php")
    Call<ModelShowCard> getcards(@Query("mobile_id") String mobile_id);

    @GET("Cards/addtocard.php")
    Call<ModelAddtoCart> addtocart(@Query("item_id") String item_id, @Query("mobile_id") String mobile_id , @Query("price") String price, @Query("quantity") String quantity, @Query("unit") String unit);

    @GET("Sign/signup.php")
    Call<ModelSignUp> usersignup(@Query("first_name") String first_name, @Query("last_name") String last_name, @Query("email") String email, @Query("password") String password , @Query("mobile") String mobile);

}