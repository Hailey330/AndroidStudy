package com.cos.mvvmex01;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    // 뷰모델이 가지고 있을 데이터를 정의함
    private LiveData<List<Note>> allNotes; // DB에서 select 데이터 → 변할 때마다 옵저버 발동
    private NoteRepository noteRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRepository = new NoteRepository();
        allNotes = noteRepository.
    }

    public LiveData<List<Note>> 구독하기() {
        return allNotes;
    }

    public void 추가하기(Note note) {
        noteRepository.save(note);
    }

    public void 삭제하기(Note note) {
        noteRepository.delete(note);
    }
}
