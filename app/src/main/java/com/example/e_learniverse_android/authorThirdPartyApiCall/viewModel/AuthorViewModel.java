package com.example.e_learniverse_android.authorThirdPartyApiCall.viewModel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.e_learniverse_android.authorThirdPartyApiCall.repository.AuthorRepository;
import com.example.e_learniverse_android.dto.AuthorResponseDto;

import org.checkerframework.checker.units.qual.A;

import java.util.List;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */
public class AuthorViewModel extends AndroidViewModel {
    private final AuthorRepository authorRepository;
    private final MutableLiveData<List<AuthorResponseDto>> listOfAuthors = new MutableLiveData<>();

    public AuthorViewModel(@NonNull Application application) {
        super(application);
        authorRepository = AuthorRepository.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public MutableLiveData<List<AuthorResponseDto>> getListOfAuthors(){{
        return authorRepository.getListOfAuthors();
    }}

    public MutableLiveData<String> getErrorString(){{
        return authorRepository.getErrorString();
    }}
}
