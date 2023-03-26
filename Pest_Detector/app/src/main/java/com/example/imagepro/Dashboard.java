package com.example.imagepro;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    RelativeLayout rrl_home, rrl_dashboard, rrl_scan, rrl_contact, rrl_about;
    ImageView btn_home, btn_dashboard, btn_scan, btn_contact, btn_about;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Dashboard");

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
        rrl_dashboard.setBackgroundColor(getResources().getColor(android.R.color.white));
        btn_dashboard.setImageResource(R.drawable.dashboardgreen);
    }

    private void setButton() {
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AboutUs.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Dashboard.this, R.anim.fade_in, R.anim.fade_out);
                Dashboard.this.startActivity(intent, options.toBundle());
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Contact.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Dashboard.this, R.anim.fade_in, R.anim.fade_out);
                Dashboard.this.startActivity(intent, options.toBundle());
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, CameraActivity.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Dashboard.this, R.anim.fade_in, R.anim.fade_out);
                Dashboard.this.startActivity(intent, options.toBundle());
            }
        });

        btn_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Home.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Dashboard.this, R.anim.fade_in, R.anim.fade_out);
                Dashboard.this.startActivity(intent, options.toBundle());
            }
        });
    }
    public void ClickAphid(View view) {
        redirectActivity(this,Aphids.class);
    }


    public void ClickCutworm(View view) {
        redirectActivity(this,Cutworms.class);
    }

    public void ClickLeafMiners(View view) {
        redirectActivity(this,Leaf_Miners.class);
    }

    public void ClickSlug(View view) {
        redirectActivity(this,Slugs.class);
    }

    public void ClickWhitefly(View view) {
        redirectActivity(this,Whiteflies.class);
    }



    public void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }

}