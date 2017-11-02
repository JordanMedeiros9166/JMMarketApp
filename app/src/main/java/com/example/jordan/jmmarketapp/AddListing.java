package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddListing extends AppCompatActivity implements View.OnClickListener{

    Button btnCancel, btnAdd;
    EditText etLocation, etSize, etPrice, etBeds, etBaths;
    Spinner spType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_listing);

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


    public void addListenerOnSpinnerItemSelect(){
        spType.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    public void onClick(View v){

        switch(v.getId()){

            case R.id.btnAdd:
                //add to listing table
                break;
            case R.id.btnCancel:

                finish();
                break;
            case R.id.spType:
                Toast.makeText(AddListing.this,String.valueOf(spType.getSelectedItem()),Toast.LENGTH_SHORT);



        }


    }

}
