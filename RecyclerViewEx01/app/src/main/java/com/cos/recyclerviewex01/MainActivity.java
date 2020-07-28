package com.cos.recyclerviewex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private RecyclerView rvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovie = findViewById(R.id.rv_movie);
        MovieAdapter adapter = new MovieAdapter();
        adapter.addItem(new Movie("써니", R.drawable.mov01));
        adapter.addItem(new Movie("완득이", R.drawable.mov02));
        adapter.addItem(new Movie("괴물", R.drawable.mov03));
        adapter.addItem(new Movie("라디오스타", R.drawable.mov04));
        adapter.addItem(new Movie("비열한 거리", R.drawable.mov05));
        adapter.addItem(new Movie("왕의 남자", R.drawable.mov06));
        adapter.addItem(new Movie("아일랜드", R.drawable.mov07));
        adapter.addItem(new Movie("웰컴 투 동막골", R.drawable.mov08));
        adapter.addItem(new Movie("헬보이", R.drawable.mov09));
        adapter.addItem(new Movie("백 투더 퓨처", R.drawable.mov10));
        adapter.addItem(new Movie("여인의 향기", R.drawable.mov11));
        adapter.addItem(new Movie("쥬라기 공원", R.drawable.mov12));

        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        rvMovie.setAdapter(adapter);
    }
}