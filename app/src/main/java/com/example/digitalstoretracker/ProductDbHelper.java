package com.example.digitalstoretracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class ProductDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shop_mgmt_db";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "products";
    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_PRODUCT_PRICE = "product_price";
    public static final String COL_PRODUCT_QTY = "product_qty";

    public ProductDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+COL_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_PRODUCT_NAME+" VARCHAR(50), "+COL_PRODUCT_PRICE+" VARCHAR(20), "+COL_PRODUCT_QTY+" VARCHAR(20) )";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_products = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(drop_products);
        onCreate(db);
    }
    public long addProduct(@NonNull ProductModel product)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues product_data = new ContentValues();

        if(!product.getProduct_name().isEmpty());
        {
            product_data.put(COL_PRODUCT_NAME,product.getProduct_name());
        }
        if(!product.getProduct_price().isEmpty());
        {
            product_data.put(COL_PRODUCT_NAME,product.getProduct_price());
        }
        if(!product.getProduct_quantity().isEmpty());
        {
            product_data.put(COL_PRODUCT_NAME,product.getProduct_quantity());
        }
        long productInsertedId = db.insert(TABLE_NAME,null,product_data);
        return productInsertedId;
    }
    public int updateProduct(String id,ProductModel product)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues uProductData = new ContentValues();
        if(product.getProduct_name().isEmpty()) {
            uProductData.put(COL_PRODUCT_NAME, product.getProduct_name());
        }
        if(product.getProduct_price().isEmpty()) {
            uProductData.put(COL_PRODUCT_PRICE, product.getProduct_price());
        }
        if(product.getProduct_quantity().isEmpty()) {
            uProductData.put(COL_PRODUCT_QTY, product.getProduct_quantity());
        }
        int updatedId = db.update(TABLE_NAME,uProductData,COL_PRODUCT_ID+" = ?",new String[]{id});
        return updatedId;
    }
}
