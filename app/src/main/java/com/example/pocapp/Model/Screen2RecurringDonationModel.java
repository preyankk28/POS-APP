package com.example.pocapp.Model;

public class Screen2RecurringDonationModel {
    String posid;
    int numberOfPayment;
    String scheduleInterval;
    boolean isRecurring;
    int donationAmount;
    String expirydate;
    String cardno;
    String cVcode;
    String paymentDate;
    boolean isChargeScheduled;
    String message;
    String donationId;

    public Screen2RecurringDonationModel(String posid, int numberOfPayment, String scheduleInterval, boolean isRecurring, int donationAmount, String expirydate, String cardno, String cVcode, String paymentDate, boolean isChargeScheduled) {
        this.posid = posid;
        this.numberOfPayment = numberOfPayment;
        this.scheduleInterval = scheduleInterval;
        this.isRecurring = isRecurring;
        this.donationAmount = donationAmount;
        this.expirydate = expirydate;
        this.cardno = cardno;
        this.cVcode = cVcode;
        this.paymentDate = paymentDate;
        this.isChargeScheduled = isChargeScheduled;
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
