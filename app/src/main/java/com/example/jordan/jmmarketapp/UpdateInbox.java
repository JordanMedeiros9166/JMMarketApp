package com.example.jordan.jmmarketapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jordan on 12/30/2017.
 */

public class UpdateInbox  extends AsyncTask<Void,Void,Void>{
    Timer timer = new Timer();
    String mUser;
    private Context myContext;
    public UpdateInbox (Context context, String user){
        myContext = context;
        mUser = user;
    }
    int i = 0;

        @Override
        protected Void doInBackground(Void... voids){
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    //TODO: update mail every 10 sec async?

                    Log.d("AsyncBackgroundTask:","Fetching info....." + i + mUser);
                    i++;
                }
            }, 1000, 15000);
            return null;

        }
}
