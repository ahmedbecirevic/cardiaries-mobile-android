package com.androidapp.cardiaries;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void register(User user);

    @Query("SELECT COUNT(*) FROM users WHERE username = :username AND password = :password")
    int login (String username, String password);

    @Query("SELECT COUNT(*) FROM users WHERE username = :username")
    int checkAccount (String username);

    @Query("SELECT * FROM users WHERE id = :id")
    List<User> getUser (long id);
}
