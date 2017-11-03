package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddListing extends AppCompatActivity implements View.OnClickListener{

    DatabaseFactory dbmanager = new DatabaseFactory(this);
    Button btnCancel, btnAdd;
    EditText etLocation, etSize, etPrice, etBeds, etBaths;
    Spinner spType;
    String type,beds,baths,location,size,price;
    String currUser ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_listing);

        Intent intent = getIntent();
        currUser = intent.getStringExtra("user");

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etSize = (EditText) findViewById(R.id.etSize);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etBeds = (EditText) findViewById(R.id.etBeds);
        etBaths = (EditText) findViewById(R.id.etBaths);
        spType = (Spinner) findViewById(R.id.spType);

        addListenerOnSpinnerItemSelect();

        btnCancel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }
    // custom type menu selector
    public void addListenerOnSpinnerItemSelect(){
        spType.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void onClick(View v){

        type = spType.getSelectedItem().toString();
        beds = etBeds.getText().toString();
        baths = etBaths.getText().toString();
        location = etLocation.getText().toString();
        size = etSize.getText().toString();
        price = etPrice.getText().toString();


        switch(v.getId()){

            case R.id.btnAdd:
                //add to listing table
                HouseInfo h = new HouseInfo();
                h.setUser(currUser);
                h.setType(type);
                h.setBeds(beds);
                h.setBaths(baths);
                h.setLocation(location);
                h.setSize(size);
                h.setPrice(price);
                dbmanager.InsertHouse(h);
                Toast.makeText(getApplicationContext(), "Successfully listed!", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.btnCancel:
                //finish activity and go back.
                finish();
                break;
            case R.id.spType:
                Toast.makeText(AddListing.this,String.valueOf(spType.getSelectedItem()),Toast.LENGTH_SHORT);



        }


    }

}
