package br.ufc.crateus.exerciciodao.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.ufc.crateus.exerciciodao.model.Carro;

@Dao
public interface CarroDAO {

    @Query("SELECT * FROM carro")
    List<Carro> getAll();

    @Query("SELECT * FROM carro WHERE id IN (:carroId)")
    List<Carro> loadAllByIds(int[] carroId);

    @Query("SELECT * FROM carro WHERE id = :carroId")
    Carro getById(int carroId);

    @Query("SELECT * FROM carro WHERE marca LIKE :marca LIMIT 1")
    Carro findByMarca(String marca);

    @Insert
    void insertAll(Carro... carros);

    @Insert
    void insert(Carro carro);

    @Delete
    void delete(Carro carro);

    @Update
    void update(Carro carro);
}