package com.example.e_learniverse_android.rest_client.AdvanceRetrofit.error;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AnantaAkashPodder on 25/12/2023.
 */
public class ApiError {

    @SerializedName("status")
    private int statusCode;

    private String endpoint;

    @SerializedName("error")
    private String message = "Unknown error";

    public int getStatusCode() {
        return statusCode;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getMessage() {
        return message;
    }
}
