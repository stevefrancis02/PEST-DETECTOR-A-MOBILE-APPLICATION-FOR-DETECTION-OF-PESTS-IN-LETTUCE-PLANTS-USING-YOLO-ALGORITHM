package com.example.imagepro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Whiteflies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiteflies);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Whiteflies");

    }
}