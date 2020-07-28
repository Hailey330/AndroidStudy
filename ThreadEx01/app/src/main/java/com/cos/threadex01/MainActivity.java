package com.cos.threadex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private Button btnExecute, btnStop;
    private ProgressBar progressBar;
    private int value = 0; // 진행바 퍼센트
    private BackgroundTask task; // 얘를 잡아야 중지가 가능함 - while문 멈추게하기
    private boolean threadStatus = true;

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setProgress(value); // 최초 실행시 bar = 0 으로 잡힘
            threadStatus = true;
            Log.d(TAG, "onPreExecute: ");
        }

        // 타겟 run() 메소드
        @Override
        protected Integer doInBackground(Integer... integers) { // 스레드 실행시 인수 받기
            Log.d(TAG, "doInBackground: ");
            while (value <= 100 && threadStatus) {
                value = value + 5;
                publishProgress(value);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 정상적으로 수행이 됐으면 1, 안됐으면 -1 => post() 받음 
            return 1;
        }

        // UI 스레드에 그림을 그려주는 메소드
        @Override
        protected void onProgressUpdate(Integer... values) { // publishProgress 인수 받기
            super.onProgressUpdate(values);
            Log.d(TAG, "onProgressUpdate: ");
            progressBar.setProgress(values[0]); // Integer[] values
        }

        // 타겟 run() 이후 실행 메소드
        @Override
        protected void onPostExecute(Integer integer) { // doInBackground 리턴 값 받기
            super.onPostExecute(integer);
            Log.d(TAG, "onPostExecute: ");
            Toast.makeText(MainActivity.this, "다운로드 완료", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInit(); // 찾고
        mListener(); // 리스너 등록
    }

    private void mListener() {
        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new BackgroundTask();
                task.execute();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threadStatus = false;
                task.cancel(true); // 스레드를 완전히 종료시킴 → 재실행 X
            }
        });
    }

    private void mInit() {
        btnExecute = findViewById(R.id.btn_execute);
        btnStop = findViewById(R.id.btn_stop);
        progressBar = findViewById(R.id.progressBar);
    }
}