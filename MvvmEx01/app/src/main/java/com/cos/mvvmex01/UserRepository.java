package com.cos.mvvmex01;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserRepository {

    // select 할 때만 쿼리 적고, 나머지는 insert, update, delete 어노테이션 걸면 된다.
    @Query("SELECT * FROM user")
    List<User> findAll();

    @Query("SELECT * FROM user WHERE uid = :uid")
    User findById(int uid);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);


}
