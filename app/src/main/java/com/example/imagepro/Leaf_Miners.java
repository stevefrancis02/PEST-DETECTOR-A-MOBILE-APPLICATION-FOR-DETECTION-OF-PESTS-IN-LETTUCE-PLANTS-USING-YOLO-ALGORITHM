package com.example.imagepro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Leaf_Miners extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaf_miners);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Leaf miners");

    }
}