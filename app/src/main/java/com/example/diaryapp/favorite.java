package com.example.diaryapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.Toolbar;

public class favorite extends Activity {
    FrameLayout frameLayout_for_map;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat);
        setContentView(R.layout.favorite);
//        frameLayout_for_map = (FrameLayout)findViewById(R.id.framelayout_for_map);
//        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.googlemap, frameLayout_for_map, true);
    }
}

