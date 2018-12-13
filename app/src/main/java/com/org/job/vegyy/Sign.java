package com.org.job.vegyy;

import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class Sign extends AppCompatActivity {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        frameLayout= (FrameLayout)findViewById(R.id.SignLayout);

        SignInFragment fragment = new SignInFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.SignLayout,fragment).commit();

    }
}
