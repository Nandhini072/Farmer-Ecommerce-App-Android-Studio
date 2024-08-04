package com.example.farmerecommercee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button buttonFarmer = findViewById(R.id.buttonFarmer);
        Button buttonCustomer = findViewById(R.id.buttonCustomer);

        buttonFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Farmer button click
                // You can perform actions specific to the Farmer here
                startActivityForRole(postfarmer.class, "Farmer");
            }
        });

        buttonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Customer button click
                // You can perform actions specific to the Customer here
                startActivityForRole(customerview.class, "Customer");
            }
        });
    }

    private void startActivityForRole(Class<?> targetActivity, String role) {
        // Start an activity based on the selected role (Farmer or Customer)
        // You can customize this based on your requirements
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("userRole", role);
        startActivity(intent);
    }
}
