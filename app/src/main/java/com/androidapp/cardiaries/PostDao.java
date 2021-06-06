package com.androidapp.cardiaries;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface PostDao {
    @Insert
    void makeNewPost(Post post);
}
