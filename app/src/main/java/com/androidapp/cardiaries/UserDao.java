package com.androidapp.cardiaries;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void register (User user);

    @Query("SELECT * FROM users WHERE email = :username AND password = :password")
    void login (String username, String password);
}
