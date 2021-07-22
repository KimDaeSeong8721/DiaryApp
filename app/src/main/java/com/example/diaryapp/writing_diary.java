package com.example.diaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class writing_diary extends AppCompatActivity{
    FrameLayout frameLayout2;
    LinearLayout btn_take_a_picture;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writing_diary);
        //구글맵 인플레이트(favorite.xml)
        frameLayout2 = (FrameLayout)findViewById(R.id.framelayout2);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.googlemap, frameLayout2, true);
        //버튼 이벤트(사진 찍기)
        btn_take_a_picture = (LinearLayout) findViewById(R.id.btn_take_a_picture);
        btn_take_a_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
    }
}
