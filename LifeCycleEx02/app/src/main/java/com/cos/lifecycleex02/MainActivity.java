package com.cos.lifecycleex02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    // Activity Context 적을 때 전역변수로 걸어두는 것이 좋다.
    private Context mContext = MainActivity.this; // MainActivity 의 모든 것을 들고 있음
    private Button btnNum, btnEmail;
    private TextView tvNum, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNum = findViewById(R.id.btn_num);
        btnEmail = findViewById(R.id.btn_email);
        tvNum = findViewById(R.id.tv_num);
        tvEmail = findViewById(R.id.tv_email);

        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SubActivity.class);
                // startActivity(intent); 이동만 할 때 쓰임
                startActivityForResult(intent, 1); // 이동 및 응답 받을 때
                // requestCode 를 enum 으로 설정해두면 다른 사람이 봐도 알 수 있음
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Sub2Activity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    // 콜백 함수 - 화면이 꺼졌을 때 받아오는 값
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: 콜백 받음");

        if (requestCode == 1) { // MainActivity 의 requestCode
            if (resultCode == 10) { // SubActivity 의 requsetCode
                tvNum.setText(data.getStringExtra("number"));
            } else if (resultCode == 20) {
                tvEmail.setText(data.getStringExtra("email"));
            }

        }
    }
}