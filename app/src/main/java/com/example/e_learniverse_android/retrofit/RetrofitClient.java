package com.example.e_learniverse_android.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AnantaAkashPodder on 8/6/2023.
 */
public class RetrofitClient {

    private static String baseUrl = "";
    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
