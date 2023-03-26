package com.example.imagepro;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Walkthrough extends AppCompatActivity {

    ViewPager slider;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;

    TextView[] dots;

    Button btn_get_started, btn_skip;

    Animation animation;

    int currentPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_walkthrough);

        slider = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.linear_layout);
        btn_get_started = findViewById(R.id.btn_get_started);

        sliderAdapter = new SliderAdapter(this);

        slider.setAdapter(sliderAdapter);

        addDots(0);

        slider.addOnPageChangeListener(changeListener);

        btn_get_started.setVisibility(View.INVISIBLE);

        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Walkthrough.this, Home.class);
                ActivityOptions options = ActivityOptions
                        .makeCustomAnimation(Walkthrough.this, R.anim.slide_left, R.anim.slide_left);
                Walkthrough.this.startActivity(intent, options.toBundle());
            }
        });
    }

    public void next(View view) {
    if (currentPosition == sliderAdapter.getCount() - 1) {
        // launch Home activity
        Intent intent = new Intent(Walkthrough.this, Home.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(Walkthrough.this, R.anim.slide_left, R.anim.slide_left);
        Walkthrough.this.startActivity(intent, options.toBundle());
    } else {
        // move to next slide
        slider.setCurrentItem(currentPosition + 1);
    }
}
    private void addDots(int position){

        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.darkgreen));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            currentPosition = position;

            if(position == 0){
                btn_get_started.setVisibility(View.INVISIBLE);
            } else if (position == 1){
                btn_get_started.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(Walkthrough.this,R.anim.slide_left);
                btn_get_started.setAnimation(animation);
                btn_get_started.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}