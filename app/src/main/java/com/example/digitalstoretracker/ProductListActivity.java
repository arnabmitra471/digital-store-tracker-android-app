package com.example.digitalstoretracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    ListView productList;
    ArrayList<ProductModel> allProducts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        productList = findViewById(R.id.productList);

        ProductModel p1 = new ProductModel("Soap","25","10");
        ProductModel p2 = new ProductModel("Mustard Oil","130","100");
        ProductModel p3 = new ProductModel("Ghee","50","110");
        ProductModel p4 = new ProductModel("Chicken masala","50","86");
        ProductModel p5 = new ProductModel("Biriyani masala","67","1000");
        ProductModel p6 = new ProductModel("Eggs","5.5","180");
        ProductModel p7 = new ProductModel("Cardamom","25","100");
        ProductModel p8 = new ProductModel("Milk","45","1000");

        allProducts.add(p1);
        allProducts.add(p2);
        allProducts.add(p3);
        allProducts.add(p4);
        allProducts.add(p5);
        allProducts.add(p6);
        allProducts.add(p7);
        allProducts.add(p8);

        ProductListAdapter adapter = new ProductListAdapter(this,allProducts);
        productList.setAdapter(adapter);
    }
}