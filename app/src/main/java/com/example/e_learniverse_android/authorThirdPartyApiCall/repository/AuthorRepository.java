package com.example.e_learniverse_android.authorThirdPartyApiCall.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.e_learniverse_android.dto.AuthorResponseDto;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.Api.AuthorApiService;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.RMARestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */
public class AuthorRepository {

    public static AuthorRepository authorRepository;
    private final MutableLiveData<List<AuthorResponseDto>> listOfAuthors = new MutableLiveData<>();

    public static AuthorRepository getInstance(){
        if(authorRepository==null){
            authorRepository = new AuthorRepository();
        }
        return authorRepository;
    }

//  TODO:
//   setValue() ---> Sets the value. If there are active observers, the value will be dispatched to them. This method must be called from the main thread.
//   postValue() ---> Posts a task to a main thread to set the given value. If you called this method multiple times before a main thread executed a posted task, only the last value would be dispatched.

    @RequiresApi(api = Build.VERSION_CODES.N)
    public MutableLiveData<List<AuthorResponseDto>> getListOfAuthors(){
        try {
            Call<List<AuthorResponseDto>> call = new RMARestClient<AuthorApiService, List<AuthorResponseDto>>()
                    .setBaseUrl("http://192.168.0.125:8080")
                    .callApiAsync(AuthorApiService.class, s -> s.getAllAuthors());

            call.enqueue(new Callback<List<AuthorResponseDto>>() {
                @Override
                public void onResponse(Call<List<AuthorResponseDto>> call, Response<List<AuthorResponseDto>> response) {
                    listOfAuthors.setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<AuthorResponseDto>> call, Throwable t) {
                    listOfAuthors.postValue(null);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfAuthors;
    }
}
