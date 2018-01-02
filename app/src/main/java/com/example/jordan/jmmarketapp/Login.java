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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

/**
 * clude the following:
 a. 1 tabview or listview and an adapter - Done
 b. 1 asynchronous task - Done - Downloads image
 c. 1 input stream to download and display a file from the web - Done
 d. 2 intents (links to other apps) SMS/9gag ( if installed)
 e. 3 buttons that save data to or retrieve data from the SQLlite database - Done

    - Register, Add Listing, Inbox show, Send Mail
 f. 1 background service that runs when the app is closed
 g. 1 firebase connection to submit device tokens and receive push notifications -Done
    - Token gets created while registering, saved to DB with Mail.
    - Push notifications work
     Create custom push notification button
 */

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink,tvErrorLabel,tvToken;
    String username,pass,token;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = AppDatabase.getAppDatabase(getApplicationContext());

        //null if google play services out of date/ failed to get token
        Log.d("myfirebasetoken", "Refreshed token: " + token);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        tvErrorLabel = (TextView) findViewById(R.id.tvErrorLabel);
        tvToken = (TextView) findViewById(R.id.tvToken);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        tvToken.setText(token);
        btnLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        username = etUsername.getText().toString();
        pass = etPassword.getText().toString();
        switch(v.getId()){
            case R.id.btnLogin:
                if(username.equals("")){
                    tvErrorLabel.setText("Invalid username.");
                }else {
                    List<Account> accountExist = db.accountDao().accountInfoMatch(username,pass);
                    if (accountExist.size()> 0){
                        Toast.makeText(getApplicationContext(), "Successfully logged in!" , Toast.LENGTH_LONG).show();
                        token = FirebaseInstanceId.getInstance().getToken();
                        Log.d("Token", token);
                        Intent mainIntent = new Intent(this, MainActivity.class);
                        mainIntent.putExtra("user", username);
                        mainIntent.putExtra("pass",pass);
                        //testing purposes
                        mainIntent.putExtra("token", token);
                        startActivity(mainIntent);
                    }else{
                        tvErrorLabel.setText("Check if username or password is incorrect.");
                        Toast.makeText(getApplicationContext(), "Check if username or password is incorrect.", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.tvRegisterLink:
                Intent regIntent = new Intent(this, Register.class);
                token = FirebaseInstanceId.getInstance().getToken();
                Log.d("Token", token);
                if(token != null){
                    regIntent.putExtra("token", token);
                }
                else{
                    Log.d("ErrorToken", token);
                }
                startActivity(regIntent);
                break;
        }
    }
}
