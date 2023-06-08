package com.example.e_learniverse_android.retrofit;

import com.example.e_learniverse_android.dto.RegisteredAndroidUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by AnantaAkashPodder on 8/6/2023.
 */
public interface ApiServiceInterface {
    @POST("api/notification/register-android-user")
    Call<RegisteredAndroidUser> registerUserToBackend(@Body RegisteredAndroidUser request);
}