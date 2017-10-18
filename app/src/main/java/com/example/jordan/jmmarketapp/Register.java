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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{

    DatabaseInfo dbmanager = new DatabaseInfo(this);
    Button btnRegister;
    EditText etEmail,etUsername,etPassword;
    TextView tvErrorLabel;
    String username,pass,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvErrorLabel = (TextView)findViewById(R.id.tvErrorLabel);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
    }

    /*  Register:
     */
    @Override
    public void onClick(View v){

        username = etUsername.getText().toString();
        pass = etPassword.getText().toString();
        email = etEmail.getText().toString();

        switch(v.getId()){
            case R.id.btnRegister:
                if(etUsername.getText().equals("")){
                    tvErrorLabel.setText("Please enter a username.");
                }else if(etPassword.getText().equals("")|| etPassword.getText().length() < 3){
                    tvErrorLabel.setText("Please enter a valid password longer then 3 characters.");
                }else if(etEmail.getText().equals("")){
                    tvErrorLabel.setText("Please enter a email address.");
                }else{
                    AccountInfo a = new AccountInfo();
                    a.setUsername(username);
                    a.setPass(pass);
                    a.setEmail(email);

                    dbmanager.Insert(a);

                    Toast.makeText(getApplicationContext(), "Successfully Registered!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this,Login.class));
                }
                break;
        }
    }
}
