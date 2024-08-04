package com.example.farmerecommercee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

public class FarmerAdapter extends ArrayAdapter<FarmerDetails> {
    public FarmerAdapter(Context context, List<FarmerDetails> farmerList) {
        super(context, 0, farmerList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FarmerDetails farmerDetails = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listitemfarmer, parent, false);
        }

        TextView textViewFarmerDetails = convertView.findViewById(R.id.textViewFarmerDetails);
        CheckBox checkBox = convertView.findViewById(R.id.checkBoxSelect);

        if (farmerDetails != null) {
            String detailsText = "Farmer Name: " + farmerDetails.getFarmerName() +
                    "\nCrop Name: " + farmerDetails.getCropName() +
                    "\nSelling Price: $" + farmerDetails.getSellingPrice() +
                    "\nWeight (kg): " + farmerDetails.getWeight() +
                    "\nPhone Number: " + farmerDetails.getPhoneNumber() +
                    "\nGoogle Maps: " + farmerDetails.getGMapLink();

            textViewFarmerDetails.setText(detailsText);
            checkBox.setChecked(farmerDetails.isSelected());

            // Handle checkbox state change
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    farmerDetails.setSelected(isChecked);
                }
            });
        }

        return convertView;
    }
}