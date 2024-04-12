package com.example.digitalstoretracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDbHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "shop_mgmt_db";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "user_details";
    public static final String COL_ID = "user_id";

    public static final String COL_NAME = "name";

    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";
    public static final String COL_CONFIRM_PASS = "confirm_pass";
    public static final String COL_MOBILE_NUM = "mobile_num";

    public UserDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME +" ("+COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_NAME+" TEXT, "+COL_EMAIL+ " VARCHAR(50) UNIQUE,"+COL_PASSWORD+" VARCHAR(50),"+COL_CONFIRM_PASS+ " VARCHAR(50),"+COL_MOBILE_NUM+ " VARCHAR(10)"+ " )";
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(drop_query);
        onCreate(db);
    }
    public long addUser(ShopUserRegData sh)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues userData = new ContentValues();
        if(!sh.getName().isEmpty())
        {
            userData.put(COL_NAME, sh.getName());
        }
        if(!sh.getEmail().isEmpty())
        {
            userData.put(COL_EMAIL,sh.getEmail());
        }

        if(!sh.getPassword().isEmpty())
        {
            userData.put(COL_PASSWORD,sh.getPassword());
        }
        if(!sh.getConfirm_pass().isEmpty())
        {
            userData.put(COL_CONFIRM_PASS,sh.getPassword());
        }
        if(!sh.getMobileNum().isEmpty())
        {
            userData.put(COL_MOBILE_NUM,sh.getMobileNum());
        }
        long insertedId = db.insert(TABLE_NAME,null,userData);
        return insertedId;
    }
    public int updateUser(String userId,ShopUserRegData sh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatedData = new ContentValues();

        String[] whereArgs = new String[]{userId};
        if (!sh.getName().isEmpty()) {
            updatedData.put(COL_NAME, sh.getName());
        }
        if (!sh.getEmail().isEmpty()) {
            updatedData.put(COL_EMAIL, sh.getEmail());
        }
        if (!sh.getPassword().isEmpty()) {
            updatedData.put(COL_PASSWORD, sh.getPassword());
        }
        if (!sh.getConfirm_pass().isEmpty()) {
            updatedData.put(COL_CONFIRM_PASS, sh.getConfirm_pass());
        }
        if (!sh.getMobileNum().isEmpty()) {
            updatedData.put(COL_MOBILE_NUM, sh.getMobileNum());
        }
        int updatedId = db.update(TABLE_NAME, updatedData,COL_ID +" = ?",whereArgs);
        return updatedId;
    }

}

