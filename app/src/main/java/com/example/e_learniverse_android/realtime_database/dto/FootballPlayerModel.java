package com.example.e_learniverse_android.realtime_database.dto;
import com.google.gson.annotations.SerializedName;

public class FootballPlayerModel {
    @SerializedName("jersey_no")
    private String jerseyNo;

    @SerializedName("name")
    private String name;


    public FootballPlayerModel(String jerseyNo, String name) {
        this.jerseyNo = jerseyNo;
        this.name = name;
    }

    public String getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(String jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FootballPlayerModel {" +
                "jerseyNo='" + jerseyNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

