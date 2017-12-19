package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Jordan on 12/19/2017.
 */

@Entity (tableName = "account")
 class Account {
    @PrimaryKey
    private int id;
    private String username;
    private String password;
    private String email;

  public Account(int id, String username, String password, String email){
      this.setId(id);
      this.setUsername(username);
      this.setPassword(password);
      this.setEmail(email);
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
}
