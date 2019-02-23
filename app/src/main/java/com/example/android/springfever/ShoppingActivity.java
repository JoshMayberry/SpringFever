package com.example.android.springfever;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //See: https://developer.android.com/training/implementing-navigation/ancestral#up
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
