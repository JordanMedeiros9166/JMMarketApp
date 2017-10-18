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
    private static final String DATABASE_NAME = "Accounts.db";
    private static final String TABLE_NAME = "Accounts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE= "CREATE TABLE Accounts (id INTEGER PRIMARY KEY," +
            "username TEXT," +
            "email TEXT," +
            "pass TEXT);";

    public DatabaseInfo(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void Insert(AccountInfo a){
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        String query = "SELECT * FROM Accounts";
        Cursor cursor = db.rawQuery(query,null);
        int cnt = cursor.getCount();

        values.put(COLUMN_ID,cnt);
        values.put(COLUMN_USERNAME, a.getUsername());
        values.put(COLUMN_EMAIL, a.getEmail());
        values.put(COLUMN_PASSWORD, a.getPass());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchUsersPassword(String username){
        db = this.getReadableDatabase();
        String query = "SELECT username, pass FROM " + TABLE_NAME;
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
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}
