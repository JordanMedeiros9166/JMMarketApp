package com.example.jordan.jmmarketapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OtherApps extends AppCompatActivity implements View.OnClickListener{
    Button btn9gag,btnSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_apps);

        btn9gag = (Button) findViewById(R.id.btn9gag);
        btnSMS = (Button) findViewById(R.id.btnSMS);

        btn9gag.setOnClickListener(this);
        btnSMS.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSMS:
                Uri uri = Uri.parse("smsto:2262185879");
                Intent go = new Intent(Intent.ACTION_SENDTO, uri);
                go.putExtra("sms_body","Testing Midterm SMS");
                startActivity(go);
                break;
            case R.id.btn9gag:
                try{
                    openApplication(this,"com.ninegag.android.app");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error loading 9GAG" , Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
    public void openApplication(Context context, String pack) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(pack);
        if (intent == null) {
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(intent);
        } else {

            try {

                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + pack)));
            }
            catch (android.content.ActivityNotFoundException e) {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + pack)));
            }
        }
    }
}
