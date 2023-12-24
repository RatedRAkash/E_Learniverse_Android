package com.example.e_learniverse_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.e_learniverse_android.AdvanceRestClient.Api.AuthorApiService;
import com.example.e_learniverse_android.AdvanceRestClient.RMARestClient;
import com.example.e_learniverse_android.dto.AuthorResponseDto;

import java.util.List;

public class AuthorActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        try {
            List<AuthorResponseDto> authorResponseDtoList = new RMARestClient<AuthorApiService, List<AuthorResponseDto>>()
                        .setBaseUrl("http://localhost:8080")
                        .callApi(AuthorApiService.class, s -> s.getAllAuthors());
            System.out.println(authorResponseDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}