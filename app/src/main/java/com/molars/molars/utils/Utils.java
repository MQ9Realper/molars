package com.molars.molars.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.molars.molars.R;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by dennis on 11/14/17.
 */

public class Utils {
    private Activity context;
    private AppCompatActivity appCompatActivity;

    public Utils(Activity activity, AppCompatActivity appCompatActivity) {
        this.context = activity;
        this.appCompatActivity = appCompatActivity;
    }

    private void centerToolbarTitle(@NonNull final Toolbar toolbar) {
        final CharSequence title = toolbar.getTitle();
        final ArrayList<View> outViews = new ArrayList<>(1);
        toolbar.findViewsWithText(outViews, title, View.FIND_VIEWS_WITH_TEXT);
        if (!outViews.isEmpty()) {
            final TextView titleView = (TextView) outViews.get(0);
            titleView.setGravity(Gravity.LEFT);
            titleView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Muli-Light.ttf"));
            final Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) titleView.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            toolbar.requestLayout();
        }
    }

    public void initToolbar(Toolbar toolbar, String title, final Class<?> destination_class){
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(context.getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_white_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, destination_class);
                context.startActivity(intent);
                context.finish();
            }
        });
        centerToolbarTitle(toolbar);
        appCompatActivity.setSupportActionBar(toolbar);
    }
}
