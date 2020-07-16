package com.cos.bottomnavigationex01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private BottomNavigationView mBottomNavigationView;
    private Fragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = new Frag1();
        setDefaultFragment();

        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, "onNavigationItemSelected: " + item.getItemId());
                Log.d(TAG, "onNavigationItemSelected: R값 : " + R.id.nav_search);
                switch (item.getItemId()) {
                    case R.id.nav_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Frag1()).commit();
                        break;
                    case R.id.nav_settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Frag2()).commit();
                        break;
                    case R.id.nav_navigation:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Frag3()).commit();
                        break;
                }
                return true;
            }
        });
    }

    // MainActivity가 처음 실행될 때 최초로 보여질 Fragment 세팅하기
    public void setDefaultFragment() {
        // 화면에 보여지는 fragment 추가, 바꿀 수 있는 객체 생성
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 첫번째로 보여지는 fragment 에는 frag1 으로 설정
        transaction.add(R.id.frame_container, mFragment);
        // fragment 변경사항 반영
        transaction.commit();

    }
}