package com.example.pocapp.Model;

import com.example.pocapp.Adapter.MDTRecyclerAdapter;

public class MDTRecyclerModel {
    String TeamMember;
    String amount;
    String PrivateText;
    public MDTRecyclerModel(){

    }

    public MDTRecyclerModel(String teamMember, String amount, String privateText) {
        TeamMember = teamMember;
        this.amount = amount;
        PrivateText = privateText;
    }

    public String getTeamMember() {
        return TeamMember;
    }

    public void setTeamMember(String teamMember) {
        TeamMember = teamMember;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrivateText() {
        return PrivateText;
    }

    public void setPrivateText(String privateText) {
        PrivateText = privateText;
    }
}
