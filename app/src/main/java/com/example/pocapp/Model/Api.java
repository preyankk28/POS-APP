package com.example.pocapp.Model;

public class Api {
    String teamName;
    String fName;


    public Api(String teamName, String fName) {
        this.teamName = teamName;
        this.fName = fName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
