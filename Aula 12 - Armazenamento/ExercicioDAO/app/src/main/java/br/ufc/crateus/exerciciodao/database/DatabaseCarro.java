package br.ufc.crateus.exerciciodao.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseCarro {

    private static AppDatabase db;

    public static AppDatabase getInstance(Context context){

        if(db==null){

            db = Room.databaseBuilder(context,
                    AppDatabase.class, "database-carros").allowMainThreadQueries().build();
        }

        return db;
    }
}
