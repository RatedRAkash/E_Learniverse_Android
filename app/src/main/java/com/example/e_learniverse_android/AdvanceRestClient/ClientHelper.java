package com.example.e_learniverse_android.AdvanceRestClient;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */
public class ClientHelper {

    public static <T> T buildRetrofitClient(Class<T> tClass, String baseUrl, int timeout, Interceptor... interceptors){
        Retrofit retrofit = buildRetrofit(baseUrl, timeout, interceptors);

        // jei "Class" pathano huise... shei Class er against ee Retrofit Client Create kore, shei Class ta kei Return kore dilam, jate kore oi CLASS er Endpoint Method gula Call korte pari
        return retrofit.create(tClass);
    }

    private static Retrofit buildRetrofit(String baseUrl, int timeout, Interceptor[] interceptors) {
        OkHttpClient okHttpClient = buildOkHTTPClient(timeout, interceptors);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient buildOkHTTPClient(int timeOut, Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS);
        if (interceptors != null && interceptors.length > 0) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }
}
