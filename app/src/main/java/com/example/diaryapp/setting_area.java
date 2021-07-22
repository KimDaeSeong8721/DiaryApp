
package com.example.diaryapp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class setting_area extends Activity
{
    Spinner spinner_area;
    FrameLayout framelayout;
    TextView btn_take_a_picture,btn_reading_diary, btn_writing_diary;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_area);
        final String[] area = {"서울특별시","세종특별자치시","인천광역시","대전광역시","광주광역시","부산광역시","대구광역시","울산광역시","경기도","강원도","충청남도","충청북도","경상북도","전라북도","경상남도","전라남도","제주도"};
        spinner_area = (Spinner)findViewById(R.id.spinner_area);
        framelayout = (FrameLayout)findViewById(R.id.framelayout);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,area);
        spinner_area.setAdapter(adapter);

        //스피너 선택시 이벤트(지역 선택항목 출력)
        spinner_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                //선택된 인덱스에 해당하는 값을 arr배열에서 얻어오기
                String str=area[position];
                Toast.makeText(getApplicationContext(),str+"의 국보목록을 보여줍니다.", Toast.LENGTH_SHORT).show();
                //스피너 선택(0:서울특별시)
                if(position==0){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_seoul, framelayout, true);
                }
                //스피너 선택(1:세종특별자치시)
                if(position==1){
                    Toast.makeText(getApplicationContext(),str+"에는 현재 지정된 국보가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                //스피너 선택(2:인천광역시)
                else if(position==2){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_incheon, framelayout, true);
                }
                //스피너 선택(3:대전광역시)
                else if(position==3){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_daejeon, framelayout, true);
                }
                //스피너 선택(4:광주광역시)
                else if(position==4){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_gwangju, framelayout, true);
                }
                //스피너 선택(5:부산광역시)
                else if(position==5){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_busan, framelayout, true);
                }
                //스피너 선택(6:대구광역시)
                else if(position==6){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_daegu, framelayout, true);
                }
                //스피너 선택(7:울산광역시)
                else if(position==7){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_ulsan, framelayout, true);
                }
                //스피너 선택(8:경기도)
                else if(position==8){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_gyunggi, framelayout, true);
                }
                //스피너 선택(9:강원도)
                else if(position==9){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_gangwon, framelayout, true);
                }
                //스피너 선택(10:충청남도)
                else if(position==10){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_chungcheongnamdo, framelayout, true);

                }
                //스피너 선택(11:충청북도)
                else if(position==11){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_gyungsangbukdo, framelayout, true);
                }
                //스피너 선택(12:경상북도)
                else if(position==12){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_gyungsangbukdo, framelayout, true);

                }
                //스피너 선택(13:전라북도)
                else if(position==13){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_junrabukdo, framelayout, true);
                }
                //스피너 선택(14:경상남도)
                    else if(position==14){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_gyungsangnamdo, framelayout, true);
                }
                //스피너 선택(15:전라남도)
                    else if(position==15){
                    framelayout.removeAllViews();
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.area_junranamdo, framelayout, true);
                }
                //스피너 선택(16:제주도)
                    else if(position==16){
                    Toast.makeText(getApplicationContext(),str+"에는 현재 지정된 국보가 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        // 버튼 이벤트(다이어리 쓰기)
        btn_writing_diary = (TextView)findViewById(R.id.btn_writing_diary);
        btn_writing_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), writing_diary.class);
                startActivity(intent);
            }
        });

        //버튼 이벤트(사진 남기기)
        btn_take_a_picture = (TextView)findViewById(R.id.btn_take_a_picture);
        btn_take_a_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        //버튼 이벤트(다이어리 보기)
        btn_reading_diary = (TextView)findViewById(R.id.btn_reading_diary);
        btn_reading_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), second_activity.class);
                startActivity(intent);
            }
        });



    }
}

