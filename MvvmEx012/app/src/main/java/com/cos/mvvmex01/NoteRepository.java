package com.cos.mvvmex01;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;

import java.util.ArrayList;
import java.util.List;

@Dao
public class NoteRepository {

    private MutableLiveData<List<Note>> allNotes = new MutableLiveData<>();

    public NoteRepository() {
        Note note = new Note();

    }

    public List<Note> findAll() {
        return allNotes;
    };

    public void delete(Note note) {
        List<Note> notes = allNotes.getValue();
        notes.remove(note);
        allNotes.s
    };

    public void save(Note note) {
        allNotes.add(note);
    };
}
