package com.example.e_learniverse_android.AdvanceRestClient.Api;

import com.example.e_learniverse_android.dto.AuthorResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */
public interface AuthorApiService {

    @GET("/authors")
    Call<List<AuthorResponseDto>> getAllAuthors();
}
