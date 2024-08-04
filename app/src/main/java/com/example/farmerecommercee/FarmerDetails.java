package com.example.farmerecommercee;

public class FarmerDetails {
    private String farmerName;
    private String cropName;
    private String sellingPrice;
    private String weight;
    private String phoneNumber;
    private String gMapLink;
    private boolean isSelected;

    public FarmerDetails(String farmerName, String cropName, String sellingPrice, String weight, String phoneNumber, String gMapLink) {
        this.farmerName = farmerName;
        this.cropName = cropName;
        this.sellingPrice = sellingPrice;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.gMapLink = gMapLink;
        this.isSelected = false;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public String getCropName() {
        return cropName;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public String getWeight() {
        return weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGMapLink() {
        return gMapLink;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}