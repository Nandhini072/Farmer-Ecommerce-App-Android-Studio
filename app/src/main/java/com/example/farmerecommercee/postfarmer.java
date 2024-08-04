package com.example.farmerecommercee;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class postfarmer extends AppCompatActivity {

    private ListView listViewFarmers;
    private FarmerAdapter farmersAdapter;
    private ArrayList<FarmerDetails> farmersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postfarmer);
        listViewFarmers = findViewById(R.id.listViewFarmers);
        Button buttonAddUser = findViewById(R.id.buttonAddUser);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        farmersList = new ArrayList<>();
        farmersAdapter = new FarmerAdapter(this, farmersList);
        listViewFarmers.setAdapter(farmersAdapter);

        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddUserDialog();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Delete the selected farmer details
                deleteSelectedFarmers();
            }
        });

        // Set the list item click listener to show details when a farmer is selected
        listViewFarmers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Show details for the selected farmer (customize as needed)
                FarmerDetails farmerDetails = farmersList.get(position);
                showMapsLinkDialog(farmerDetails.getGMapLink());
            }
        });
    }

    private void showAddUserDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_dialoguser, null);

        final EditText editTextFarmerName = dialogView.findViewById(R.id.editTextFarmerName);
        final EditText editTextCropName = dialogView.findViewById(R.id.editTextCropName);
        final EditText editTextSellingPrice = dialogView.findViewById(R.id.editTextSellingPrice);
        final EditText editTextWeight = dialogView.findViewById(R.id.editTextWeight);
        final EditText editTextPhoneNumber = dialogView.findViewById(R.id.editTextPhoneNumber);
        final EditText editTextGMapLink = dialogView.findViewById(R.id.editTextGMapLink);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView)
                .setTitle("Add User")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Get user input and add a new farmer to the list
                        String farmerName = editTextFarmerName.getText().toString();
                        String cropName = editTextCropName.getText().toString();
                        String sellingPrice = editTextSellingPrice.getText().toString();
                        String weight = editTextWeight.getText().toString();
                        String phoneNumber = editTextPhoneNumber.getText().toString();
                        String gMapLink = editTextGMapLink.getText().toString();

                        FarmerDetails newFarmer = new FarmerDetails(farmerName, cropName, sellingPrice, weight, phoneNumber, gMapLink);
                        farmersList.add(newFarmer);
                        farmersAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void showMapsLinkDialog(String mapsLink) {
        // Open Google Maps or a web browser with the specified link
        // Implementation of showMapsLinkDialog method
    }

    private void deleteSelectedFarmers() {
        ArrayList<FarmerDetails> selectedFarmers = new ArrayList<>();

        for (FarmerDetails farmerDetails : farmersList) {
            if (farmerDetails.isSelected()) {
                selectedFarmers.add(farmerDetails);
            }
        }

        farmersList.removeAll(selectedFarmers);
        farmersAdapter.notifyDataSetChanged();
        Toast.makeText(postfarmer.this, "Selected farmer details deleted", Toast.LENGTH_SHORT).show();
    }
}