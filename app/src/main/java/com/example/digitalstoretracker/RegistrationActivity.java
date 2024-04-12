package com.example.digitalstoretracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    EditText nameTxt,reg_emailTxt,reg_passwordTxt,reg_confirmPassTxt,reg_mobileNumTxt;
    Button regBtn,reg_loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameTxt = findViewById(R.id.nameTxt);
        reg_emailTxt = findViewById(R.id.reg_emailTxt);
        reg_passwordTxt = findViewById(R.id.reg_passwordTxt);
        reg_confirmPassTxt = findViewById(R.id.reg_confirmPassTxt);
        reg_mobileNumTxt = findViewById(R.id.reg_mobileNumTxt);
        regBtn = findViewById(R.id.regBtn);
        reg_loginBtn = findViewById(R.id.reg_loginBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTxt.getText().toString();
                String email = reg_emailTxt.getText().toString();
                String password = reg_passwordTxt.getText().toString();
                String confirm_pass = reg_confirmPassTxt.getText().toString();
                String mobileNum = reg_mobileNumTxt.getText().toString();
                ShopUserRegData regData = new ShopUserRegData(name,email,password,confirm_pass,mobileNum);

                UserDbHelper dbHelper = new UserDbHelper(RegistrationActivity.this);
                dbHelper.addUser(regData);
            }
        });
        reg_loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActIntent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(loginActIntent);
            }
        });

    }
}