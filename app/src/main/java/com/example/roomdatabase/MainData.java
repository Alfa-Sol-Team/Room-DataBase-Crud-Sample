package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Define Table Name.....
@Entity(tableName = "Table_Name")
public class MainData {
    //Create ID Column.....
    @PrimaryKey(autoGenerate = true)
    private int ID;

    //Create Text Column.....
    @ColumnInfo(name = "text")
    private String text;

    //Generate Getter and Setter.....
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
