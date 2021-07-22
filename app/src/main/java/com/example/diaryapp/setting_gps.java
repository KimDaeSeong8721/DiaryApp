package com.example.diaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class setting_gps extends AppCompatActivity {
    ImageView google_map;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_gps);
        google_map = (ImageView)findViewById(R.id.google_map);
        google_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"현재위치를 확인합니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), setting_area.class);
                startActivity(intent);
            }
        });
    }
}
