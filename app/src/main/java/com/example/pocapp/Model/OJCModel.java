package com.example.pocapp.Model;

public class OJCModel {
    String posid;
    int numberOfPayment;
    int platformFee;
    int donationAmount;
    String expirydate;
    String cardno;
    String message;
    String donationId;


    public OJCModel(String posid, int numberOfPayment, int platformFee, int donationAmount, String expirydate, String cardno) {
        this.posid = posid;
        this.numberOfPayment = numberOfPayment;
        this.platformFee = platformFee;
        this.donationAmount = donationAmount;
        this.expirydate = expirydate;
        this.cardno = cardno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }
}
