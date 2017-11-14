package com.molars.molars.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.molars.molars.R;
import com.molars.molars.utils.Utils;

public class AboutUsActivity extends AppCompatActivity {
    private Utils utils;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbar = (Toolbar) findViewById(R.id.toolbarAbout);
        utils = new Utils(this, this);

        utils.initToolbar(toolbar,"About Us", DashboardActivity.class);
    }
}
