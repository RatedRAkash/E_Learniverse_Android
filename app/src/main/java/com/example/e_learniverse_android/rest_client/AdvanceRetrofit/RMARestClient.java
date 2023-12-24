package com.example.e_learniverse_android.rest_client.AdvanceRetrofit;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import okhttp3.Interceptor;
import retrofit2.Response;
import retrofit2.Call;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */
public class RMARestClient<TService, TDto> {
    private String baseUrl;
    private List<Interceptor> interceptorsList = new ArrayList<>();
    private static final int DEFAULT_TIMEOUT = 60;

    // *********** Constructors ***********
    public RMARestClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RMARestClient(){
        this(null);
    }
    // *********** Methods ***********
    public RMARestClient<TService, TDto> setBaseUrl(String baseUrl){ // return kortesei ei CLASS er ei ekta OBJECT, jeno shei Object ke pore Manipulate kore arro ei CLASS er Other Methods call korte pari
        this.baseUrl = baseUrl;
        return this;
    }

    public RMARestClient<TService, TDto> addInterceptor(Interceptor... interceptors) {
        interceptorsList.addAll(Lists.newArrayList(interceptors));
        return this; // ei Class kei Return kore dilam, jate jeikhan theke Call hocche Method sheikhane Chain kore method Call kora jay
    }

    // *********** API Calling Methods ***********
    @RequiresApi(api = Build.VERSION_CODES.N)
    public TDto callApi(Class<TService> tServiceClass, Function<TService, Call<TDto>> actionFunctionalInterface) throws Exception{

        TService tServiceClassObj = ClientHelper.buildRetrofitClient(tServiceClass, baseUrl, DEFAULT_TIMEOUT,
                                                interceptorsList.toArray(new Interceptor[0]));

        Response<TDto> response = actionFunctionalInterface.apply(tServiceClassObj)
                                    .execute();

        return response.body();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Call<TDto> callApiAsync(Class<TService> tServiceClass, Function<TService, Call<TDto>> actionFunctionalInterface) throws Exception {

        TService tServiceClassObj = ClientHelper.buildRetrofitClient(tServiceClass, baseUrl, DEFAULT_TIMEOUT,
                interceptorsList.toArray(new Interceptor[0]));

        return actionFunctionalInterface.apply(tServiceClassObj);
    }
}
