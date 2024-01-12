package com.example.e_learniverse_android.register_user_to_my_backend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_learniverse_android.R;
import com.example.e_learniverse_android.register_user_to_my_backend.dto.RegisteredAndroidUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.example.e_learniverse_android.rest_client.SimpleRetrofit.RetrofitClient;
import com.example.e_learniverse_android.rest_client.SimpleRetrofit.ApiServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUserActivity extends AppCompatActivity {

    EditText mobileEditText, nameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        Button registerUser = (Button)findViewById(R.id.registerButtonId);
        mobileEditText = (EditText)findViewById(R.id.mobileId);
        nameEditText = (EditText)findViewById(R.id.nameId);

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiServiceInterface apiService = RetrofitClient.getClient().create(ApiServiceInterface.class);

                RegisteredAndroidUser request = new RegisteredAndroidUser(mobileEditText.getText().toString(), nameEditText.getText().toString(), FirebaseInstanceId.getInstance().getToken());
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
                            Toast toast = Toast.makeText(getApplicationContext(),"Registered",Toast. LENGTH_LONG);
                            toast.show();
                        } else {
                            // Handle error response
                            // Extract error information from response.errorBody()
                            Toast toast = Toast.makeText(getApplicationContext(),"Error",Toast. LENGTH_LONG);
                            toast.show();
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