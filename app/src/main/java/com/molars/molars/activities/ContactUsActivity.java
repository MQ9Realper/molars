package com.molars.molars.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.molars.molars.R;
import com.molars.molars.utils.Utils;

public class ContactUsActivity extends AppCompatActivity {
    private Utils utils;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        utils = new Utils(this,this);
        toolbar = (Toolbar) findViewById(R.id.toolbarContact);

        utils.initToolbar(toolbar,"Contact Us", DashboardActivity.class);
    }
}
