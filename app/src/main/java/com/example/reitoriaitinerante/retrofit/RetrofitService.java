package com.example.reitoriaitinerante.retrofit;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService() {
        initializateRetrofit();
    }

    private void initializateRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:9000/")
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
