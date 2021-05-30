package com.androidapp.cardiaries;

import androidx.room.Insert;

public interface PostDao {
    @Insert
    void makeNewPost(Post post);
}
