package com.cos.listviewex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private Context mContext = MainActivity.this;
    private ListView listView;
    private SingleAdapter adapter; // BaseAdapter를 extends한 내가 만든 Adapter

    private List<Movie> items = new ArrayList<>();

    public MainActivity() {
        items.add(new Movie("써니",R.drawable.mov01));
        items.add(new Movie("완득이",R.drawable.mov02));
        items.add(new Movie("괴물",R.drawable.mov03));
        items.add(new Movie("라디오스타",R.drawable.mov04));
        items.add(new Movie("비열한 거리",R.drawable.mov05));
        items.add(new Movie("왕의 남자",R.drawable.mov06));
        items.add(new Movie("아일랜드",R.drawable.mov07));
        items.add(new Movie("웰컴 투 동막골",R.drawable.mov08));
        items.add(new Movie("헬보이",R.drawable.mov09));
        items.add(new Movie("백 투더 퓨처",R.drawable.mov10));
        items.add(new Movie("여인의 향기",R.drawable.mov11));
        items.add(new Movie("쥬라기 공원",R.drawable.mov12));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        adapter = new SingleAdapter();
        adapter.addItems(items);
        listView.setAdapter(adapter);
    }
}