package com.org.job.vegyy;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.org.job.vegyy.Adapter.CartsAdapter;
import com.org.job.vegyy.Model.ModelShowCard;
import com.org.job.vegyy.Model.ModelSignUp;
import com.org.job.vegyy.Utilities.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    EditText firstname,lastname,email,password,mobile;

    Spinner mobileCode;

    Button signUpButton;

    ApiUtils apiUtils;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        firstname = (EditText)view.findViewById(R.id.FirstName);
        lastname = (EditText)view.findViewById(R.id.LastName);
        email = (EditText)view.findViewById(R.id.Email);
        password = (EditText)view.findViewById(R.id.Password);
        mobile = (EditText)view.findViewById(R.id.Phone);
        mobileCode = (Spinner)view.findViewById(R.id.MobileList);
        signUpButton = (Button)view.findViewById(R.id.ButtonSignUp);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup(firstname.getText().toString(),lastname.getText().toString(),email.getText().toString(),password.getText().toString(),"+92"+mobile.getText().toString());

            }
        });







        return view;
    }

    public void signup(String myfirst_name,String mylast_name,String myemail,String mypassword ,String mymobile) {

        apiUtils.getSOService().usersignup(myfirst_name,mylast_name,myemail,mypassword,mymobile).enqueue(new Callback<ModelSignUp>() {

            @Override
            public void onResponse(Call<ModelSignUp> call, Response<ModelSignUp> response) {

                ModelSignUp modelSignUp;
                if (response.isSuccessful()) {
                    modelSignUp = response.body();

                    if(modelSignUp.getStatusMessage().equals("Successfull")) {

                        Toast.makeText(getContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();

                    }



                } else {
                    Toast.makeText(getContext(), "Try AGAIN", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelSignUp> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


}
