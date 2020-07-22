package com.cos.navigationintentex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "Sub_Activity";
    private Context mContext = SubActivity.this;
    private NavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        init();
        NavigationViewHelper.enableNavigation(mContext, nav);
    }

    private void init() {
        nav = findViewById(R.id.nav);
    }

}