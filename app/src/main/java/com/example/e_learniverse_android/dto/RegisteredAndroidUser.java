package com.example.e_learniverse_android.dto;

/**
 * Created by AnantaAkashPodder on 8/6/2023.
 */
public class RegisteredAndroidUser {

    private String name;
    private String mobile;
    private String fcm_token;

    public RegisteredAndroidUser(String name, String mobile, String fcm_token) {
        this.name = name;
        this.mobile = mobile;
        this.fcm_token = fcm_token;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFcm_token() {
        return fcm_token;
    }

    public void setFcm_token(String fcm_token) {
        this.fcm_token = fcm_token;
    }
}
