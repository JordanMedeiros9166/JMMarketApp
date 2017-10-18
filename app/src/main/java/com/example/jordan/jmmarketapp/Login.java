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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink,tvErrorLabel;
    String username,pass;
    DatabaseInfo dbmanager = new DatabaseInfo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        tvErrorLabel = (TextView) findViewById(R.id.tvErrorLabel);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        username = etUsername.getText().toString();
        pass = etPassword.getText().toString();
        String validPass = dbmanager.searchUsersPassword(username);
        switch(v.getId()){
            case R.id.btnLogin:
                if(pass.equals(validPass)){
                    tvErrorLabel.setText("Logging in...");
                    Toast.makeText(getApplicationContext(), "Successfully logged in!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this,MainActivity.class));
                }else if(!pass.equals(validPass)){
                    tvErrorLabel.setText("Password is incorrect.");
                }else{
                    tvErrorLabel.setText("Username is incorrect or doesn't exist.");
                }
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,Register.class));
                break;
        }
    }
}
