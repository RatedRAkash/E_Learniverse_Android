package com.example.e_learniverse_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_learniverse_android.dto.RegisteredAndroidUser;
import com.example.e_learniverse_android.retrofit.ApiServiceInterface;
import com.example.e_learniverse_android.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


        Button registerUser = (Button)findViewById(R.id.registerButtonId);

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiServiceInterface apiService = RetrofitClient.getClient().create(ApiServiceInterface.class);

                RegisteredAndroidUser request = new RegisteredAndroidUser();
//                request.setField1("value1");
//                request.setField2("value2");

                // Make the API call
                Call<RegisteredAndroidUser> call = apiService.registerUserToBackend(request);
                call.enqueue(new Callback<RegisteredAndroidUser>() {
                    @Override
                    public void onResponse(Call<RegisteredAndroidUser> call, Response<RegisteredAndroidUser> response) {
                        if (response.isSuccessful()) {
                            // Handle successful response
                            RegisteredAndroidUser data = response.body();
                            // Process the response data
                        } else {
                            // Handle error response
                            // Extract error information from response.errorBody()
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisteredAndroidUser> call, Throwable t) {
                        // Handle network or API call failure
                    }
                });


            }
        });
    }
}