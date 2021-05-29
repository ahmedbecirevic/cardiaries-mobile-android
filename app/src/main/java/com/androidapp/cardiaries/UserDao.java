package com.androidapp.cardiaries;
import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

    @Insert
    void register (String email, String username, String password);
}
