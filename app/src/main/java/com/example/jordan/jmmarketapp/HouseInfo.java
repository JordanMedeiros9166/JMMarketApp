package com.example.jordan.jmmarketapp;

/**
 * Created by Jordan on 10/18/2017.
 */

public class HouseInfo {
    String type,beds, baths, location, size;
    Integer price;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setBeds(String beds){
        this.beds = beds;
    }
    public String getBeds(){
        return this.beds;
    }
    public void setBaths(String baths){
        this.baths = baths;
    }
    public String getBaths(){
        return this.baths;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }
    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return this.size;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public Integer getPrice(){
        return this.price;
    }

}
