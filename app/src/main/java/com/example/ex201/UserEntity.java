package com.example.ex201;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    //프라이머리키를 포함한 열
    public String Name;

    public boolean selected;

    public UserEntity(String name) {
        this.Name=name;
    }

    public UserEntity() {

    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //    public ImageView UserImage;
}
