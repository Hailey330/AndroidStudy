package com.cos.listviewex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private Context mContext = MainActivity.this;
    private ListView listView;
    private SingleAdapter adapter; // BaseAdapter를 extends한 내가 만든 Adapter

    private List<String> items = Arrays.asList(
            "1. 히어로즈", "2. 24시", "3. 로스트", "4. 로스트룸", "5. 빅뱅이론", "6. 프렌즈", "7. 덱스터", "8. 굴리",
            "9. 히어로즈", "10. 24시", "11. 로스트", "12. 로스트룸", "13. 빅뱅이론", "14. 프렌즈", "15. 덱스터", "16. 굴리"
    );

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