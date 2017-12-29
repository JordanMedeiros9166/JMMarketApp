package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Jordan on 12/19/2017.
 */

@Dao
public interface HouseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addHouse(House house);

    @Query("SELECT * FROM house")
    List<House> getAllHouse();

    @Query("SELECT * FROM house WHERE id = :id")
    List<House> getHouse(long id);

    @Delete
    void deleteHouse(House house);
}
