package com.example.digitalstoretracker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    ListView productList;
    Button addProductBtn;

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
        ProductModel p5 = new ProductModel("Biryani masala","67","1000");
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

        addProductBtn = findViewById(R.id.addProductBtn);
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductListActivity.this);
                LayoutInflater alertLayoutInflater = LayoutInflater.from(ProductListActivity.this);
                View alertDialogView = alertLayoutInflater.inflate(R.layout.add_product_alert_dialog,null);

                builder.setView(alertDialogView);

                // configuring the positive button of the alertDialog
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText productNameInp = alertDialogView.findViewById(R.id.productNameInp);
                        EditText productPriceInp = alertDialogView.findViewById(R.id.productPriceInp);
                        EditText productQtyInp = alertDialogView.findViewById(R.id.productQtyInp);

                        String product_name = productNameInp.getText().toString().trim();
                        String product_price = productPriceInp.getText().toString().trim();
                        String product_qty = productQtyInp.getText().toString().trim();

                        ProductDbHelper dbHelper = new ProductDbHelper(ProductListActivity.this);
                        if(product_name.isEmpty() || product_price.isEmpty() || product_qty.isEmpty())
                        {
                            Toast.makeText(ProductListActivity.this,"All fields are required",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            ProductModel product = new ProductModel(product_name,product_price,product_qty);
                            long insertedId = dbHelper.addProduct(product);
                            if(insertedId > 0)
                            {
                                Toast.makeText(ProductListActivity.this,"Product added successfully",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(ProductListActivity.this,"Product was not added successfully",Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);

                AlertDialog alertProductDialog = builder.create();
                alertProductDialog.show();

            }
        });
    }
}