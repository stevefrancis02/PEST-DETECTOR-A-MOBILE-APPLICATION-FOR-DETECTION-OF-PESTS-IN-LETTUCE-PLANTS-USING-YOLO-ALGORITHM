package com.example.imagepro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences onBoardScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make fullscreen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardScreen = getSharedPreferences("onBoardScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardScreen.getBoolean("firstTime", true);
                if (isFirstTime){
                    SharedPreferences.Editor editor = onBoardScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                    startActivity(new Intent( SplashActivity.this, Walkthrough.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashActivity.this, Home.class));
                }

            }
        } ,  4000);
    }
}