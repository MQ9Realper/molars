package com.molars.molars.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.github.jinatonic.confetti.CommonConfetti;
import com.molars.molars.R;

public class MainActivity extends AppCompatActivity {
    private FrameLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLayout = (FrameLayout) findViewById(R.id.parentLayout);
        initAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAnimation();
    }

    private void initAnimation(){
        CommonConfetti.rainingConfetti(parentLayout, new int[] { Color.parseColor("#03adee"), Color.parseColor("#ee4403"), Color.parseColor("#ee03ad") })
                .infinite().animate();
    }
}
