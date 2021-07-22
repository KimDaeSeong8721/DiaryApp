package com.example.diaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class second_activity extends AppCompatActivity {
    ListView listview_diary;
    private DrawerLayout mDrawerLayout;
    private Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // second_activiy.xml 구현 코드 (리스트뷰 관련)
        final ArrayList<String> midList = new ArrayList<String>();
        ListView listView_diary = (ListView) findViewById(R.id.listview_diary);
        final EditText edit_diaryx = (EditText) findViewById(R.id.edt_diaryx);
        Button btn_addx = (Button) findViewById(R.id.btn_addx);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);
        listView_diary.setAdapter(adapter);
        btn_addx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edit_diaryx.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        listView_diary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        //네비게이션 드로어 코드
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.menu2); //뒤로가기 버튼 이미지 지정
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();
                //방문한 국보목록 선택시
                if(id == R.id.visited)
                {
                    Toast.makeText(context, title + ": 방문한 국보목록을 확인합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), mylist.class);
                    startActivity(intent);
                }
                // 앞으로 방문할 목록 선택시
                else if(id == R.id.will_visiting)
                {
                    Toast.makeText(context, title + ": 방문할 국보목록을 확인합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), national_treasure_list.class);
                    startActivity(intent);
                }
                // 다이어리 선택시
                else if(id == R.id.diary)
                {
                    Toast.makeText(context, title + ": 다이어리를 확인합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), second_activity.class);
                    startActivity(intent);
                }
                else if(id == R.id.google_map)
                {
                    Toast.makeText(context, title + ": 지도를 확인합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), favorite.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}