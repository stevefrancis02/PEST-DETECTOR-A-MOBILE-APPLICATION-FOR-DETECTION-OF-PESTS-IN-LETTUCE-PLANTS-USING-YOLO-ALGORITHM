package com.example.imagepro;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class Contact extends AppCompatActivity {

    RelativeLayout rrl_home, rrl_dashboard, rrl_scan, rrl_contact, rrl_about;
    ImageView btn_home, btn_dashboard, btn_scan, btn_contact, btn_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Contact us");

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
        rrl_contact.setBackgroundColor(getResources().getColor(android.R.color.white));
        btn_contact.setImageResource(R.drawable.contactgreen);
    }

    private void setButton() {
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, Home.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Contact.this, R.anim.fade_in, R.anim.fade_out);
                Contact.this.startActivity(intent, options.toBundle());
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, AboutUs.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Contact.this, R.anim.fade_in, R.anim.fade_out);
                Contact.this.startActivity(intent, options.toBundle());
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Contact.this, R.anim.fade_in, R.anim.fade_out);
                Contact.this.startActivity(intent, options.toBundle());
            }
        });

        btn_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, Dashboard.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Contact.this, R.anim.fade_in, R.anim.fade_out);
                Contact.this.startActivity(intent, options.toBundle());
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }

}