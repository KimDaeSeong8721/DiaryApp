package com.example.diaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    ImageView btn_pencil, btn_picture, btn_helper;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_pencil = (ImageView) findViewById(R.id.btn_pencil);
        btn_picture = (ImageView)findViewById(R.id.btn_picture);
        btn_helper = (ImageView)findViewById(R.id.btn_helper);
        //버튼 이벤트(도움말)
        btn_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog_helper,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);
                dlg.setNegativeButton("확인", null);
                dlg.show();
            }
        });

        //버튼 이벤트(다이어리 보기)
        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), second_activity.class);
                startActivity(intent);
            }
        });
        //버튼 이벤트(다이어리 쓰기)
        btn_pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), setting_area.class);
                startActivity(intent);
            }
        });
    }


}