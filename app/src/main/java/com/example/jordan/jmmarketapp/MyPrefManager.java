package com.example.jordan.jmmarketapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jordan on 12/29/2017.
 */

public class MyPrefManager {

    private static final String MY_PREF_NAME = "mypref";
    private static final String KEY_TOKEN = "token";

    private static Context cntxt;
    private static MyPrefManager myInstance;

    private MyPrefManager(Context context){
        cntxt = context;
    }
    public static synchronized MyPrefManager getInstance(Context context){
        if(myInstance == null)
            myInstance = new MyPrefManager(context);
        return myInstance;
    }
    public boolean storeToken(String token){
        SharedPreferences sharePref = cntxt.getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString(KEY_TOKEN,token);
        editor.apply();
        return true;

    }
    public String getToken(){
        SharedPreferences sharedPref = cntxt.getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getString(KEY_TOKEN,null);
    }
}
