package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Jordan on 12/19/2017.
 */

@Entity (tableName = "account")
 class Account {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "token")
    private String token;

  public Account(int id, String username, String password, String email, String token){
      this.setId(id);
      this.setUsername(username);
      this.setPassword(password);
      this.setEmail(email);
      this.setToken(token);
  }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken(){ return token; }
    public void setToken(String token) {
        this.token = token;
    }
}
