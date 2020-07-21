package com.cos.lifecycleex01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    // onCreate()에서 다운하기
    private String downloadData = "";
    private String currentState = "";


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");

        currentState = "에너지 50";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        Log.d(TAG, "onResume: 현재 에너지는 " + currentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

        SharedPreferences pref = getSharedPreferences("pref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("currentState", currentState);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("pref", 0);
        SharedPreferences.Editor editor = pref.edit();
        currentState = pref.getString("currentState", "");

        // 다운로드 시작
        // UI 스레드가 그림을 그려주는데 다운로드를 맡기면 UI가 종료됨 → 새 스레드 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i=1; i<4; i++) {
                        Thread.sleep(1000);
                        Log.d(TAG, "run: " + i + "초");
                    }
                    downloadData = "다운받은 데이터";
                    Log.d(TAG, "run: 다운로드 종료");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Log.d(TAG, "onCreate: ");
    }
}