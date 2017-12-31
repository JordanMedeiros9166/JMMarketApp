package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Jordan on 12/30/2017.
 */

@Entity(tableName = "mail")
 class Mail {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "sender")
    private String sender;
    @ColumnInfo(name = "receiver")
    private String receiver;
    @ColumnInfo(name = "messege")
    private String messege;

    public Mail(String sender, String receiver, String messege){
        this.setSender(sender);
        this.setReceiver(receiver);
        this.setMessege(messege);
    }


    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessege() {
        return messege;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
