package com.example.mydoctor.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Diseases.class, version = 1)
public abstract class DiseasesDatabase extends RoomDatabase {

    /** We make it static so that the class can be singleton,
     means we cannot make multiple instance of the class
     which means we use the same instance of the class everywhere
     **/
    private static DiseasesDatabase instance;

    /** this method has no method body
     this will be used to access the note_item DAO **/
    public abstract DiseasesDao diseasesDao();

    /** Synchronized means that a single thread at time can access the class **/
    public static synchronized DiseasesDatabase getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DiseasesDatabase.class, "diseases_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  instance;
    }
}
