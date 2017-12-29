package com.example.jordan.jmmarketapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowListings extends AppCompatActivity {
    int count =0;
    ListView v;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getAppDatabase(getApplicationContext());
        setContentView(R.layout.activity_show_listings);
         v = (ListView) findViewById(R.id.listView1);
        fetchInfo();
    }



    public void fetchInfo(){
        List<House> h = db.houseDao().getAllHouse();
        ArrayList<String> ar = new ArrayList<>();
        for(House house : h){
            ar.add(""+ (String.format("Name: %s  \nPrice: %s\nType: %s  \nLocation: %s , Id<testing>: %s \n",
                    house.getUsername(),house.getPrice(),house.getType(),house.getLocation(),house.getUserId())));
        }
        ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ar);
        v.setTextFilterEnabled(true);
        v.setAdapter(items);
    }
}