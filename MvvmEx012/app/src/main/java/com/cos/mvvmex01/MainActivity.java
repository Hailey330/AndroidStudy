package com.cos.mvvmex01;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private NoteViewModel noteViewModel;
    private NoteAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class); // 레퍼런스 객체 생성
        // 옵저버 달기 : 구독 → Live Data 를 바라봄
        // Live Data 가 가지고 있는 observe 함수
        noteViewModel.구독하기().observe(this, new Observer<List<Note>>() { // 옵저버가 지켜보는 애가 변할 때 뭘 할 것인지 정의함
            @Override
            public void onChanged(List<Note> notes) {
                Log.d(TAG, "onChanged: 구독하고 있는 데이터가 변경되었습니다.");
                adapter.setNotes(notes);

            }
        });
    }
}