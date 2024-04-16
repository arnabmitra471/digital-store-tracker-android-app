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
        if(view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.custom_product_listview, parent, false);
        }

            TextView product_name = view.findViewById(R.id.product_name);
            TextView product_price = view.findViewById(R.id.product_price);
            TextView product_quantity = view.findViewById(R.id.product_quantity);

            product_name.setText(allProducts.get(position).getProduct_name());
            product_price.setText(allProducts.get(position).getProduct_price());
            product_quantity.setText(allProducts.get(position).getProduct_quantity());

        return view;
    }
}
