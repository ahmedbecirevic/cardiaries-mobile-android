package com.androidapp.cardiaries;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PostDao {
    @Insert
    void makeNewPost(Post post);

    @Query("SELECT * FROM posts")
    List<Post> getAll();
}
