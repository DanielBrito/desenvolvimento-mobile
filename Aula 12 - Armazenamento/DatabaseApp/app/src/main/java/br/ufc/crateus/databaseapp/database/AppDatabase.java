package br.ufc.crateus.databaseapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.ufc.crateus.databaseapp.dao.UserDAO;
import br.ufc.crateus.databaseapp.model.User;

@Database(entities = {User. class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDao();
}
