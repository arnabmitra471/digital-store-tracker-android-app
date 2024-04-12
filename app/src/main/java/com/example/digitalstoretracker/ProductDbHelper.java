package com.example.digitalstoretracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shop_mgmt_db";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "products";
    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_PRODUCT_PRICE = "product_price";
    public static final String COL_PRODUCT_QTY = "product_qty";

    public ProductDbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
