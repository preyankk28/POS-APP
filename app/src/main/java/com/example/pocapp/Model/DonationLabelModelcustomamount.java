package com.example.pocapp.Model;

public class DonationLabelModelcustomamount {
    String name;
    String amount;
    String image;

    public DonationLabelModelcustomamount(String name, String amount, String image) {
        this.name = name;
        this.amount = amount;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
