package com.example.imagepro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Aphids extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aphids);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Aphids");

    }

}