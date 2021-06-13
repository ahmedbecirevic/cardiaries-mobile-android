package com.androidapp.cardiaries;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "posts")
public class Post {
    @PrimaryKey(autoGenerate = true)
    long id;

    String description;

    String carName;

    public Post(String description, String carName) {
        this.description = description;
        this.carName = carName;
    }

    //    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    private byte[] image;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
