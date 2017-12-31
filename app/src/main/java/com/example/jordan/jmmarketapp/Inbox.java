package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Inbox extends AppCompatActivity {
    private AppDatabase db;
    ListView inbox;
    TextView tvError;
    String currUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        db = AppDatabase.getAppDatabase(getApplicationContext());
        Intent intent = getIntent();
        currUser = intent.getStringExtra("user");
        tvError = (TextView) findViewById(R.id.tvError);
        inbox = (ListView) findViewById(R.id.listViewInbox);


            fetchInfo();
        new UpdateInbox().execute();
    }
    public void fetchInfo(){
        List<Mail> m = db.mailDao().getMail(currUser);
        ArrayList<String> ar = new ArrayList<>();
        if (m.size() <= 0){
            tvError.setText("No new messeges.");
        }
        else{
            for(Mail mail : m){
                ar.add(""+ (String.format("From: %s  \nMessege: %s",
                        mail.getSender(), mail.getMessege())));
            }
            ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ar);
            inbox.setTextFilterEnabled(true);
            inbox.setAdapter(items);
        }

    }


}
