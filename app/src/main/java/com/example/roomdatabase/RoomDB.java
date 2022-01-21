package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Add Database Entities.....
@Database(entities = {MainData.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    //Define database name.....
    private static final String DATABASE_NAME = "database";
    //Create database instance.....
    private static RoomDB database;

    public synchronized static RoomDB getInstance(Context context) {
        //Check Condition.....
        if (database == null) {
            //When database in null.....
            //Initialize database.....
            database = Room.databaseBuilder(context.getApplicationContext()
                    , RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    //Create DAO.....
    public abstract MainDao mainDao();
}
