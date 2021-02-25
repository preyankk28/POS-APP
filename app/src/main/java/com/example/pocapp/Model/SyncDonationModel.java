package com.example.pocapp.Model;

public class SyncDonationModel {
    String email;
    String firstName;
    String lastName;
    String phone;
    String donationID;
    String remark;
    boolean isAnonymous;
    boolean isRemarkPrivate;
    String message;

    public SyncDonationModel(String email, String firstName, String lastName, String phone, String donationID, String remark, boolean isAnonymous, boolean isRemarkPrivate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.donationID = donationID;
        this.remark = remark;
        this.isAnonymous = isAnonymous;
        this.isRemarkPrivate = isRemarkPrivate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
