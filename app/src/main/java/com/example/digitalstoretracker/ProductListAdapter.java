package com.example.digitalstoretracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<ProductModel> {

    Activity context;
    ArrayList<ProductModel> allProducts;
    public ProductListAdapter(@NonNull Activity context, ArrayList<ProductModel> allProducts) {
        super(context,R.layout.custom_product_listview,allProducts);
        this.context = context;
        this.allProducts = allProducts;
    }
    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent)
    {
        if(view == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.custom_product_listview,parent,true);

            TextView product_name = rowView.findViewById(R.id.product_name);
            TextView product_price = rowView.findViewById(R.id.product_price);
            TextView product_quantity = rowView.findViewById(R.id.product_quantity);


        }
    }
}
