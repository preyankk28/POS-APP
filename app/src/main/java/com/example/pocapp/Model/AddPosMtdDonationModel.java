package com.example.pocapp.Model;

import java.util.ArrayList;

public class AddPosMtdDonationModel {
    int caseId;
    String expirydate;
    String cardno;
    String cVcode;
    int donationAmount;
    String posid;
    int platformPercent;
    ArrayList<pOSMTDDonationVMsModel> pOSMTDDonationVMs;
    String message;
    String donationId;

    public AddPosMtdDonationModel(int caseId, String expirydate, String cardno, String cVcode, int donationAmount, String posid, int platformPercent, ArrayList<pOSMTDDonationVMsModel> pOSMTDDonationVMs) {
        this.caseId = caseId;
        this.expirydate = expirydate;
        this.cardno = cardno;
        this.cVcode = cVcode;
        this.donationAmount = donationAmount;
        this.posid = posid;
        this.platformPercent = platformPercent;
        this.pOSMTDDonationVMs = pOSMTDDonationVMs;
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
