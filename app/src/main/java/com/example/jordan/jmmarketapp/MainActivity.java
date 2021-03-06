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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnLogout,btnDownload;
    EditText etUsername;
    TextView tvWelcome,tvCitation;
    ImageView ivDL;
    String passUser,passPass,myToken;
    String DL_URL = "http://www.clker.com/cliparts/s/5/L/w/F/E/house-hi.png";

    private AppDatabase db;
    private Account acc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String pass = intent.getStringExtra("pass");




        etUsername = (EditText) findViewById(R.id.etUsername);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        ivDL = (ImageView) findViewById(R.id.imageDownload);
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvCitation = (TextView) findViewById(R.id.tvCitation);

        passPass = pass;
        passUser = user;

        tvWelcome.setText("Welcome, "+ user + "!");
        btnLogout.setOnClickListener(this);
        btnDownload.setOnClickListener(this);
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
                //make profile page turned into token page for final
                Intent tokIntent = new Intent(this, DisplayToken.class);
                tokIntent.putExtra("user", passUser);
                startActivity(tokIntent);
                return true;
            case R.id.navMesseges:
                //make messeges page
                Intent msgIntent = new Intent(this, Inbox.class);
                msgIntent.putExtra("user", passUser);
                startActivity(msgIntent);
                return true;
            case R.id.navBrowse:
                //show listings page
                startActivity(new Intent(this, ShowListings.class));
                return true;
            case R.id.navFriends:
                //show friends list

                startActivity(new Intent(this, OtherApps.class));
                return true;
            case R.id.navAddListing:
                Intent addIntent = new Intent(this, AddListing.class);
                addIntent.putExtra("user", passUser);
                addIntent.putExtra("pass", passPass);
                startActivity(addIntent);
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
            case R.id.btnDownload:
                Toast.makeText(getApplicationContext(), "Downloading... Aysnc/doInBackground image", Toast.LENGTH_LONG).show();
                AsyncBackDL imgAsync = new AsyncBackDL(MainActivity.this,ivDL);
                imgAsync.execute(DL_URL);
                tvCitation.setText("Credit: " + DL_URL);
                break;
        }
    }
}
