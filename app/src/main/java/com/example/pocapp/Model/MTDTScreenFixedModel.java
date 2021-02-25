package com.example.pocapp.Model;

import android.renderscript.Sampler;

import java.sql.Array;
import java.util.ArrayList;

public class MTDTScreenFixedModel {

    int caseId;
    String teamName;
    String fName;
    ArrayList<Api> data;

    public MTDTScreenFixedModel() {

    }




    public ArrayList<Api> getData() {
        return data;
    }

    public void setData(ArrayList<Api> data) {
        this.data = data;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public MTDTScreenFixedModel(int caseId) {
        this.caseId = caseId;
    }
}
