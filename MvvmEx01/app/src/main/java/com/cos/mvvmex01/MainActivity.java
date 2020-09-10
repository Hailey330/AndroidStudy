package com.cos.mvvmex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db-cos")
                .fallbackToDestructiveMigration() // 스키마의 버전 변경 가능
                .allowMainThreadQueries() // 메인스레드에서 DB에 I/O를 가능하게 해줌
                .build();
        // db-cos 라는 이름으로 DB 생성하면서 AppDatabase.class가 메모리에 뜸 → 세팅 끝!

        userRepository = db.userRepository();
        User user = new User("Hongcha", "Scone");
        userRepository.insert(user);
        Log.d(TAG, "onCreate: 데이터가 잘 저장되었네요.");

        List<User> users = userRepository.findAll();
        Log.d(TAG, "users 데이터를 불러왔어요. " + users);

        User userEntity = userRepository.findById(1);
        Log.d(TAG, "userEntity 데이터 : " + userEntity);
    }
}