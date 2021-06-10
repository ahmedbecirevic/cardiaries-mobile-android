package com.androidapp.cardiaries;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Post.class}, version = 1)
public abstract class CarDiariesDatabase extends RoomDatabase {

    private static final String databaseName = "cardiaries";
    private static CarDiariesDatabase carDiariesDatabase;

    public static CarDiariesDatabase getCarDiariesDatabase (Context context) {
        if (carDiariesDatabase == null) {
            carDiariesDatabase = Room.databaseBuilder(context, CarDiariesDatabase.class, databaseName).allowMainThreadQueries().build();
        }
        return carDiariesDatabase;
    }

    public abstract UserDao userDao();
    public abstract PostDao postDao();
}
