/* Real Estate App (Potential actually release)
   Prog3210 - Section 3
   By Jordan Medeiros.

   Time Log:
   - Sept 25th, 1 Hour(s), - Getting comfortable with Android Studio.
   - Sept 26th, 2 Hour(s), - Login, Register, MainActivity
   - Sept 28th, 1 Hour(s), - Hard coded account, Error catch, Assignment 1 submission.

   *Started uploading to Github, not keeping time logs here anymore.*
 */
package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddListing extends AppCompatActivity implements View.OnClickListener{


    Button btnCancel, btnAdd;
    EditText etLocation, etSize, etPrice, etBeds, etBaths;
    Spinner spType;
    String type,beds,baths,location,size,price;
    String currUser,currPass =" ";
    private AppDatabase db;
    //private House house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_listing);
       db = AppDatabase.getAppDatabase(getApplicationContext());

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String pass = intent.getStringExtra("pass");
        currPass = pass;
        currUser = user;

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
                //add to listing tablegag
                //db.houseDao().addHouse(new House(currUser,type,beds,baths,location,size,price));


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
