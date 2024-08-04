package com.example.farmerecommercee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the entered name
                String enteredName = editTextName.getText().toString();

                // Check if the name is not empty
                if (!enteredName.isEmpty()) {
                    // If not empty, show a welcome message and proceed to login activity
                    String welcomeMessage = "Welcome, " + enteredName + "!";
                    Toast.makeText(MainActivity.this, welcomeMessage, Toast.LENGTH_SHORT).show();

                    // Start the login activity
                    Intent intent = new Intent(MainActivity.this, login.class);
                    startActivity(intent);
                } else {
                    // Show a message if the name is empty
                    editTextName.setError("Please enter your name");
                }
            }
        });
    }
}
