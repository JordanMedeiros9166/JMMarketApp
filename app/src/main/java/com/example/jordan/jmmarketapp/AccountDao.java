package com.example.jordan.jmmarketapp;



import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Jordan on 12/19/2017.
 */
@Dao
public interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAccount(Account account);

    @Query("SELECT * FROM account")
    List<Account> getAllAccount();

    @Query("SELECT * FROM account WHERE id = :id")
    List<Account> getAccount (long id);

    @Query("SELECT * FROM account WHERE username LIKE :username")
    List<Account> findAccountByUsername(String username);

    @Query("SELECT * FROM account WHERE username LIKE :search AND password LIKE :pass")
    List<Account> accountInfoMatch(String search,String pass);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateAccount(Account account);

    @Delete
    void delete(Account accounts);
}
