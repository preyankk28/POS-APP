package com.example.pocapp.Model;

public class Screen2Model {
    String posid;
    int caseId;
    int donationAmount;
    String expirydate;
    String cardno;
    String cVcode;
    String paymentDate;
    boolean isChargeScheduled;
    String message;
    String donationId;

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

    public Screen2Model() {

    }

    public Screen2Model(String posid, int caseId, int donationAmount, String expirydate, String cardno, String cVcode, String paymentDate, boolean isChargeScheduled) {
        this.posid = posid;
        this.caseId = caseId;
        this.donationAmount = donationAmount;
        this.expirydate = expirydate;
        this.cardno = cardno;
        this.cVcode = cVcode;
        this.paymentDate = paymentDate;
        this.isChargeScheduled = isChargeScheduled;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }


    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getcVcode() {
        return cVcode;
    }

    public void setcVcode(String cVcode) {
        this.cVcode = cVcode;
    }

}
