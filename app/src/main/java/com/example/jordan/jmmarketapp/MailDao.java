package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Jordan on 12/30/2017.
 */
@Dao
public interface MailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMail(Mail mail);
    @Query("SELECT * FROM mail")
    List<Mail> getAllMail();
    @Query("SELECT * FROM mail WHERE receiver = :receiver")
    List<Mail> getMail(String receiver);
}
