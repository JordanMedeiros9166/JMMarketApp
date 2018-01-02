package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMail extends AppCompatActivity implements View.OnClickListener{

    EditText etSendTo, etBody;
    Button btnSend, btnCancel;
    String sender,receiver,msgBody;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mail);
        db = AppDatabase.getAppDatabase(getApplicationContext());
        Intent intent = getIntent();
        sender = intent.getStringExtra("user");

        etBody = (EditText) findViewById(R.id.etBody);
        etSendTo = (EditText) findViewById(R.id.etSendTo);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnSend.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){

        //TODO:Error checks, empty spaces trim name.
        receiver = etSendTo.getText().toString();
        msgBody = etBody.getText().toString();
        switch(v.getId()){
            case R.id.btnSend:
                db.mailDao().addMail(new Mail(sender, receiver, msgBody));
                Toast.makeText(this, String.valueOf(" Messege sent to: " + receiver), Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.btnCancel:
                finish();
                break;
        }


    }

}
