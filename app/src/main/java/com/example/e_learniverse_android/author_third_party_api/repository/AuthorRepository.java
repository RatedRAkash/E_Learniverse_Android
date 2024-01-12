package com.example.e_learniverse_android.author_third_party_api.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.e_learniverse_android.register_user_to_my_backend.dto.AuthorResponseDto;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.Api.AuthorApiService;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.RMARestClient;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.error.ApiError;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.error.ErrorUtils;

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
    private final MutableLiveData<String> errorStringMutableLivedata = new MutableLiveData<>();

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
                    if(response.isSuccessful()){
                        listOfAuthors.setValue(response.body());
                    }
                    else{
                        //TODO Method-1: eivabe korte pari

                        /*
                        switch (response.code()){
                            case 404:
                                errorStringMutableLivedata.postValue("Server returned error: Author Not Found");
                                break;
                            case 500:
                                errorStringMutableLivedata.postValue("Server returned error: Server is Broker");
                                break;
                            default:
                                errorStringMutableLivedata.postValue("Server returned error: unknown error");
                                break;
                        }
                        */


                         /*
                        //TODO Method-2: direct response.errorBody() eivabe Access korte paro
                        try{
                            errorStringMutableLivedata.postValue("Server returned error: " + response.errorBody().toString());
                        }catch (Exception exc){
                            errorStringMutableLivedata.postValue("Server returned error: unknown error");
                        }
                        */


                        //TODO Method-3: ErrorUtil banaiye korbo
                        ApiError apiError = ErrorUtils.parseErrorFromResponse(response);
                        errorStringMutableLivedata.postValue("StatusCode: "+ apiError.getStatusCode() + "& Message: "+apiError.getMessage());
                    }

                }

                @Override
                public void onFailure(Call<List<AuthorResponseDto>> call, Throwable t) {
                    listOfAuthors.postValue(null);
                    errorStringMutableLivedata.postValue("Network Error!!! Connect to internet");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfAuthors;
    }

    public MutableLiveData<String> getErrorString(){
        return errorStringMutableLivedata;
    }
}
