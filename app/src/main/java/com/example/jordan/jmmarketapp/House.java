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
        this.setUserId(userId);
        this.setUsername(username);
        this.setType(type);
        this.setBeds(beds);
        this.setBaths(baths);
        this.setLocation(location);
        this.setSize(size);
        this.setPrice(price);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getBaths() {
        return baths;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
