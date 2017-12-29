package com.example.jordan.jmmarketapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowListings extends AppCompatActivity {
    int count =0;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getAppDatabase(getApplicationContext());
        setContentView(R.layout.activity_show_listings);

        fetchInfo();
    }


    public void fetchInfo(){

        StringBuilder sb = new StringBuilder();
        //List<House> h = db.houseDao().getHouse(count);
        List<House> h = db.houseDao().getAllHouse();

        ListView v = (ListView) findViewById(R.id.listings);

        for(House house : h){
            sb.append(String.format("Name: %s   Price: %s   Type: %s - \n Location: %s , Id: %s \n",
                    house.getUsername(),house.getPrice(),house.getType(),house.getLocation(),house.getUserId()));
        }

        List<String> sbItems = new ArrayList<>(Arrays.asList(sb.toString()));
        ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, sbItems);
        v.setTextFilterEnabled(true);
        v.setAdapter(items);


    }
}