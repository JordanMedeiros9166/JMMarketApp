/* Real Estate App (Potential actually release)
   Prog3210 - Section 3
   By Jordan Medeiros.

   Time Log:
   - Sept 25th, 1 Hour(s), - Getting comfortable with Android Studio.
   - Sept 26th, 2 Hour(s), - Login, Register, MainActivity
   - Sept 28th, 1 Hour(s), - Hard coded account, Error catch, Assignment 1 submission.

   *Started uploading to Github not keeping time logs here anymore.*
 */
package com.example.jordan.jmmarketapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnLogout;
    EditText etUsername;
    TextView tvWelcome;
    String passUser = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");


        etUsername = (EditText) findViewById(R.id.etUsername);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        passUser = user;
        tvWelcome.setText("Welcome, "+ user);
        btnLogout.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.navAccount:
                //make profile page
                return true;
            case R.id.navMesseges:
                //make messeges page
                return true;
            case R.id.navBrowse:
                //show listings page

                return true;
            case R.id.navFriends:
                //show friends list
                return true;
            case R.id.navAddListing:
               // Intent addIntent = new Intent(this, AddListing.class);
                //addIntent.putExtra("user", passUser);
                //startActivity(addIntent);
                return true;
            case R.id.navLogout:
                startActivity(new Intent(this,Login.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
