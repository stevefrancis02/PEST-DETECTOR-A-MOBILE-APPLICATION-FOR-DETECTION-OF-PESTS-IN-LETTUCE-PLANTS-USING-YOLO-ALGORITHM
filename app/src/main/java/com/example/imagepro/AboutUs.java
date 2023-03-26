package com.example.imagepro;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class AboutUs extends AppCompatActivity {

    RelativeLayout rrl_home, rrl_dashboard, rrl_scan, rrl_contact, rrl_about;
    ImageView btn_home, btn_dashboard, btn_scan, btn_contact, btn_about;

    public Toolbar supportActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("About");


        rrl_home = findViewById(R.id.rrl_home);
        rrl_dashboard = findViewById(R.id.rrl_dashboard);
        rrl_scan = findViewById(R.id.rrl_scan);
        rrl_contact = findViewById(R.id.rrl_contact);
        rrl_about = findViewById(R.id.rrl_about);
        btn_home = findViewById(R.id.btn_home);
        btn_dashboard = findViewById(R.id.btn_dashboard);
        btn_scan = findViewById(R.id.btn_scan);
        btn_contact = findViewById(R.id.btn_contact);
        btn_about = findViewById(R.id.btn_about);

        setButton();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setActiveActivity();

    }

    private void setActiveActivity() {
        rrl_about.setBackgroundColor(getResources().getColor(android.R.color.white));
        btn_about.setImageResource(R.drawable.aboutgreen);
    }

    private void setButton() {
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this, Home.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(AboutUs.this, R.anim.fade_in, R.anim.fade_out);
                AboutUs.this.startActivity(intent, options.toBundle());
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this, Contact.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(AboutUs.this, R.anim.fade_in, R.anim.fade_out);
                AboutUs.this.startActivity(intent, options.toBundle());
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this, CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(AboutUs.this, R.anim.fade_in, R.anim.fade_out);
                AboutUs.this.startActivity(intent, options.toBundle());
            }
        });

        btn_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUs.this, Dashboard.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(AboutUs.this, R.anim.fade_in, R.anim.fade_out);
                AboutUs.this.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        // End the current activity and return to the home activity
        Intent intent = new Intent(AboutUs.this, Home.class);
        startActivity(intent);
        finish();
    }


}