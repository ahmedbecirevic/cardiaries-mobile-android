package com.androidapp.cardiaries;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PostDao {
    @Insert
    void makeNewPost(Post post);

    @Query("SELECT * FROM 'posts'")
    List<Post> getAll();

    @Query("SELECT * FROM 'posts' WHERE id = :id LIMIT 1")
    Post getPostById (long id);

    @Query("UPDATE posts SET carName = :carName, description = :description WHERE id = :id")
    void updatePost (String carName, String description, long id);

    @Query("DELETE FROM posts WHERE id = :id")
    void deletePost (long id);

    @Query("SELECT COUNT(*) FROM posts")
    int getNumberOfPosts ();
}
