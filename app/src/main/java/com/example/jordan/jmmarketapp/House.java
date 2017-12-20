package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Jordan on 12/19/2017.
 */

@Entity(tableName = "house",
        foreignKeys = {@ForeignKey(
                            entity = Account.class,
                            parentColumns = "id",
                            childColumns = "userId",
                            onDelete = ForeignKey.CASCADE
        )},
        indices = { @Index(value = "id")})
public class House {
    @PrimaryKey(autoGenerate = true)
    long id;
    private long userId;
    private String username;
    private String type;
    private String beds;
    private String baths;
    private String location;
    private String size;
    private String price;

    public House(long userId,String username,String type,String beds,String baths,String location,String size,String price){
        this.userId = userId;
        this.username = username;
        this.type = type;
        this.beds = beds;
        this.baths = baths;
        this.location = location;
        this.size = size;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }
    public String getType() {
        return type;
    }
    public String getBeds() {
        return beds;
    }
    public String getBaths() {
        return baths;
    }
    public String getLocation() {
        return location;
    }
    public String getSize() {
        return size;
    }
    public String getPrice() {
        return price;
    }
    public long getUserId() {
        return userId;
    }

}
