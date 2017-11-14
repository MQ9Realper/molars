package com.molars.molars.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.molars.molars.R;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layoutCustomLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutCustomLogo = (LinearLayout) findViewById(R.id.layoutCustomLogo);
        initAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAnimation();
    }

    private void initAnimation() {
        YoYo.with(Techniques.FadeIn).duration(2800).repeat(0).playOn(layoutCustomLogo);

        goToDashboard();
    }

    private void goToDashboard() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        }, 2800);
    }
}
