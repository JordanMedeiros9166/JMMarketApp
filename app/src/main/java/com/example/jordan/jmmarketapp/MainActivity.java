/* Real Estate App (Potential actually release)
   Prog3210 - Section 3
   By Jordan Medeiros.

   Time Log:
   - Sept 25th, 1 Hour(s), - Getting comfortable with Android Studio.
   - Sept 26th, 2 Hour(s), - Login, Register, MainActivity
   - Sept 28th, 1 Hour(s), - Hard coded account, Error catch, Assignment 1 submission.
 */
package com.example.jordan.jmmarketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogout;
    EditText etName,etEmail,etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Not yet coded until i get the database connected.
        //Will hold the person's information when logged in.
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(this);
        Login log = new Login();
        String user = log.getUser();
        String pass = log.getPass();

        //Passing the user and password in place of email temporarily, same concept.
        etName.setText(user);
        etUsername.setText(user);
        etEmail.setText(pass);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnLogout:
                startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
