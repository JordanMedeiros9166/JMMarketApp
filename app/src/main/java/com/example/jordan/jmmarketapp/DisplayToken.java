package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class DisplayToken extends AppCompatActivity {
    private AppDatabase db;
    private Account acc;
    EditText etToken;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_token);
        db = AppDatabase.getAppDatabase(getApplicationContext());
        Intent intent = getIntent();
        user = intent.getStringExtra("user");

        etToken = (EditText) findViewById(R.id.etToken);
        if(db.accountDao().findAccountByUsername(user).size()>0){

            etToken.setText(db.accountDao().findTokenByUsername(user).get(0).getToken());
        }

    }

}
