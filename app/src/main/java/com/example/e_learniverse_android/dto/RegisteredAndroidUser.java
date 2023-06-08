package com.example.e_learniverse_android.dto;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AnantaAkashPodder on 8/6/2023.
 */

public class RegisteredAndroidUser {
    @SerializedName("mobile")
    private String mobile;

    @SerializedName("name")
    private String name;

    @SerializedName("fcm_token")
    private String fcmToken;

    public RegisteredAndroidUser(String mobile, String name, String fcmToken) {
        this.mobile = mobile;
        this.name = name;
        this.fcmToken = fcmToken;
    }

    // Getters and setters

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}

