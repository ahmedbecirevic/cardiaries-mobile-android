package com.androidapp.cardiaries;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "posts")
public class Post {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo
    String description;

    @ColumnInfo
    String carName;

//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    private byte[] image;

}
