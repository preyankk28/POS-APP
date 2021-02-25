package com.example.pocapp.Model;

public class pOSMTDDonationVMsModel {
    String teanId;
    int memberId;

    public pOSMTDDonationVMsModel(String teanId, int memberId) {
        this.teanId = teanId;
        this.memberId = memberId;
    }

    public String getTeanId() {
        return teanId;
    }

    public void setTeanId(String teanId) {
        this.teanId = teanId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
