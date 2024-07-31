package com.example.reitoriaitinerante.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService() {
        initializateRetrofit();
    }

    private void initializateRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.18.132.195:9000")
                .addConverterFactory(GsonConverterFactory
                        .create(new Gson())).build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}