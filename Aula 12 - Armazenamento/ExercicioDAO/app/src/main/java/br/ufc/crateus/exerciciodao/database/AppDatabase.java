package br.ufc.crateus.exerciciodao.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.ufc.crateus.exerciciodao.dao.CarroDAO;
import br.ufc.crateus.exerciciodao.model.Carro;

@Database(entities = {Carro. class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract CarroDAO carroDAO();
}