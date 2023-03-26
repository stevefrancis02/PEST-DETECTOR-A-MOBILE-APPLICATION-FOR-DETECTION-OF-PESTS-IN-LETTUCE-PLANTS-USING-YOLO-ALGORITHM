package com.example.imagepro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Home extends AppCompatActivity {

    RelativeLayout rrl_home, rrl_dashboard, rrl_scan, rrl_contact, rrl_about;
    ImageView btn_home, btn_dashboard, btn_scan, btn_contact, btn_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Home");

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
        rrl_home.setBackgroundColor(getResources().getColor(android.R.color.white));
        btn_home.setImageResource(R.drawable.homegreen);
    }

    private void setButton() {
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AboutUs.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Home.this, R.anim.fade_in, R.anim.fade_out);
                Home.this.startActivity(intent, options.toBundle());
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Contact.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Home.this, R.anim.fade_in, R.anim.fade_out);
                Home.this.startActivity(intent, options.toBundle());
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Home.this, R.anim.fade_in, R.anim.fade_out);
                Home.this.startActivity(intent, options.toBundle());
            }
        });

        btn_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Dashboard.class);
               ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Home.this, R.anim.fade_in, R.anim.fade_out);
                Home.this.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (this.getClass() == Home.class) {
            // If current activity is Home, show confirmation dialog
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit App")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // If user confirms exit, kill the app
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        } else {
            // If current activity is not Home, go back to previous activity
            super.onBackPressed();
        }
    }



}