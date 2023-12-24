package com.example.e_learniverse_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.e_learniverse_android.adapter.RecyclerAdapter;
import com.example.e_learniverse_android.adapter.RecyclerViewClickInterface;
import com.example.e_learniverse_android.dto.AuthorResponseDto;

import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.RMARestClient;
import com.example.e_learniverse_android.rest_client.AdvanceRetrofit.Api.AuthorApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorActivity extends AppCompatActivity implements RecyclerViewClickInterface {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<AuthorResponseDto> authorList;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        recyclerView = findViewById(R.id.recyclerViewId);

        authorList = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(authorList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);


        try {
            Call<List<AuthorResponseDto>> call = new RMARestClient<AuthorApiService, List<AuthorResponseDto>>()
                    .setBaseUrl("http://192.168.0.125:8080")
                    .callApiAsync(AuthorApiService.class, s -> s.getAllAuthors());

            call.enqueue(new Callback<List<AuthorResponseDto>>() {
                @Override
                public void onResponse(Call<List<AuthorResponseDto>> call, Response<List<AuthorResponseDto>> response) {
                    // Handle successful response
                    List<AuthorResponseDto> data = response.body();
                    Toast.makeText(getApplicationContext(), "Author Data Fetched", Toast.LENGTH_LONG).show();
                    loadAllList(data);
                }

                @Override
                public void onFailure(Call<List<AuthorResponseDto>> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllList(List<AuthorResponseDto> newList) {
        this.authorList = newList;
        recyclerAdapter.authorList = newList;
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), this.authorList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(int position) {
        Toast.makeText(getApplicationContext(), this.authorList.get(position).getName(), Toast.LENGTH_LONG).show();
    }
}