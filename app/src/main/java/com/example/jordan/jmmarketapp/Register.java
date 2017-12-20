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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Register extends AppCompatActivity implements View.OnClickListener{


    Button btnRegister, btnCancel;
    EditText etEmail,etUsername,etPassword;
    TextView tvErrorLabel;
    String username,pass,email;
    int count;
    private AppDatabase db;
    private Account acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = AppDatabase.getAppDatabase(getApplicationContext());
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvErrorLabel = (TextView)findViewById(R.id.tvErrorLabel);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnRegister.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
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
                if(username.length() < 1 ){
                    tvErrorLabel.setText("Please enter a username.");
                }else if(pass.length() < 3){
                    tvErrorLabel.setText("Please enter a valid password longer then 3 characters.");
                }else if(email.length() < 1){
                    tvErrorLabel.setText("Please enter a email address.");
                }else{

                        List<Account> dupeCheck = db.accountDao().findAccountByUsername(username);
                    if (dupeCheck.size() > 0){
                        tvErrorLabel.setText("Name in use already, try again");
                    }else{

                        List<Account> accounts = db.accountDao().getAllAccount();
                        if (accounts.size() == 0|| accounts.isEmpty() ){
                            count = 1;
                            db.accountDao().addAccount(new Account(count,username,pass,email));
                            acc = db.accountDao().getAllAccount().get(count);
                            Toast.makeText(this, String.valueOf(acc.getId()+ ", " + acc.getUsername()), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this,Login.class));
                        }else{
                            count = accounts.size() +1;
                            int curr = count -1;
                            db.accountDao().addAccount(new Account(count,username,pass,email));
                            acc = db.accountDao().getAllAccount().get(curr);
                            Toast.makeText(this, String.valueOf(acc.getId()+ ", " + acc.getUsername()), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this,Login.class));
                        }
                        // Toast.makeText(this, String.valueOf(acc), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnCancel:
                    startActivity(new Intent(this,Login.class));
                break;
            case R.id.btnClearDB:
                    AppDatabase.destroyInstance();
        }
    }
}
