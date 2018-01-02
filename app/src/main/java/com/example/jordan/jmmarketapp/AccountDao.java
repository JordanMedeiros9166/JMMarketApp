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

    /**
     * Account
     * @param account
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAccount(Account account);

    @Query("SELECT * FROM account")
    List<Account> getAllAccount();

    @Query("SELECT * FROM account WHERE id = :id")
    List<Account> getAccount (long id);

    @Query("SELECT * FROM account WHERE username LIKE :username")
    List<Account> findAccountByUsername(String username);

    @Query("SELECT * FROM account WHERE username LIKE :username AND password LIKE :pass")
    List<Account> accountInfoMatch(String username,String pass);

    @Query("SELECT id,token FROM account WHERE username LIKE :username")
    List<Account> findTokenByUsername(String username);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateAccount(Account account);

    @Delete
    void deleteAccount(Account account);
}
