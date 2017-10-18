package com.example.jordan.jmmarketapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jordan on 10/18/2017.
 */

public class DatabaseInfo extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Market.db";
    //Account info
    private static final String ACCOUNT_TABLE_NAME = "Accounts";
    private static final String ACCOUNT_COLUMN_ID = "id";
    private static final String ACCOUNT_COLUMN_USERNAME = "username";
    private static final String ACCOUNT_COLUMN_EMAIL = "email";
    private static final String ACCOUNT_COLUMN_PASSWORD = "pass";

    //House info
    private static final String HOUSE_TABLE_NAME = "Listings";
    private static final String HOUSE_COLUMN_ID = "id";
    private static final String HOUSE_COLUMN_TYPE = "type";
    private static final String HOUSE_COLUMN_BEDS = "beds";
    private static final String HOUSE_COLUMN_BATHS = "baths";
    private static final String HOUSE_COLUMN_LOCATION = "location";
    private static final String HOUSE_COLUMN_SIZE = "size";
    private static final String HOUSE_COLUMN_PRICE = "price";

    SQLiteDatabase db;
    private static final String ACCOUNT_TABLE_CREATE= "CREATE TABLE Accounts (id INTEGER PRIMARY KEY," +
            "username TEXT," +
            "email TEXT," +
            "pass TEXT);";

    private static final String HOUSE_TABLE_CREATE= "CREATE TABLE Listings (id INTEGER PRIMARY KEY," +
            "type TEXT," +
            "beds TEXT," +
            "baths TEXT," +
            "location TEXT," +
            "size TEXT," +
            "price TEXT);";

    public DatabaseInfo(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(ACCOUNT_TABLE_CREATE);
        db.execSQL(HOUSE_TABLE_CREATE);
        this.db = db;
    }

    public void InsertAccount(AccountInfo a){
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        String query = "SELECT * FROM Accounts";
        Cursor cursor = db.rawQuery(query,null);
        int cnt = cursor.getCount();

        values.put(ACCOUNT_COLUMN_ID,cnt);
        values.put(ACCOUNT_COLUMN_USERNAME, a.getUsername());
        values.put(ACCOUNT_COLUMN_EMAIL, a.getEmail());
        values.put(ACCOUNT_COLUMN_PASSWORD, a.getPass());

        db.insert(ACCOUNT_TABLE_NAME,null,values);
        db.close();
    }

    public String searchUsersPassword(String username){
        db = this.getReadableDatabase();
        String query = "SELECT username, pass FROM " + ACCOUNT_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String u, p;
        p = "";
        if(cursor.moveToFirst()){
            do {
                u = cursor.getString(0);
                if(u.equals(username)){
                    p = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return p;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS " + ACCOUNT_TABLE_NAME;
        String query1 = "DROP TABLE IF EXISTS " + HOUSE_TABLE_NAME;
        db.execSQL(query);
        db.execSQL(query1);
        this.onCreate(db);
    }

}
