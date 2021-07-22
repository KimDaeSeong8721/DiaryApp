package com.example.diaryapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;


// 지도를 활용하기 위해 OnMapReadyCallback 인터페이스 사용
public class googlemap extends AppCompatActivity implements OnMapReadyCallback {
    // 전역 변수
    GoogleMap gMap; // 구글 맵 변수
    MapFragment mapFragment; // 맵 프래그먼트 변수
    GroundOverlayOptions groundOverlayOptions; // cctv 아이콘을 저장할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemap);
        // googlemap.xml의 fragment를 mapFragment 변수에 대입
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment_for_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    // OnMapReadyCallback 인터페이스의 추상 메소드인 onMapReady(GoogleMap) 메소드 : 구글 지도의 초기화할 내용
    public void onMapReady(GoogleMap fragment_for_map) {
        gMap = fragment_for_map; // GoogleMap 파라미터 변수 fragment_for_map을 전역 변수 gMap에 대입(다른 메소드에서 gMap 사용)
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // 위성 지도가 보이도록 설정
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.879923, 128.628136), 15)); // 지도의 중심을 동대구역으로 이동(위도, 경도, 확대 레벨)
        gMap.getUiSettings().setZoomControlsEnabled(true); // 확대/축소 버튼을 화면 오른쪽 아래에 보이도록 설정
        // 지도를 클릭하면 작동할 리스너
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            // onMapClick() : 지도를 클릭하면 작동하는 메소드(LatLng 클릭한 위치의 경도, 위도)
            public void onMapClick(LatLng point) {
                groundOverlayOptions = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.like2)).position(point, 100f, 100f); // cctv 마크 생성(위치 및 크기 지정)
                gMap.addGroundOverlay(groundOverlayOptions); // 화면에 생성한 cctv 마크를 그림
            }
        });
    }
}