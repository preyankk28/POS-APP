package com.example.pocapp.Model;

import java.util.ArrayList;

public class AddPostMTDSomeDonationModel {
    int caseId;
    String expirydate;
    String cardno;
    String cVcode;
    int donationAmount;
    String posid;
    int platformPercent;
    ArrayList<pOSMTDDonationVMsModelforSome> pOSMTDDonationVMs;
    String message;
    String donationId;

    public AddPostMTDSomeDonationModel(int caseId, String expirydate, String cardno, String cVcode, int donationAmount, String posid, int platformPercent, ArrayList<pOSMTDDonationVMsModelforSome> pOSMTDDonationVMs) {
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
