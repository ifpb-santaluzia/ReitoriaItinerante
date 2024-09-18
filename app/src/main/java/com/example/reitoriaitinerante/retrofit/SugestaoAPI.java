package com.example.reitoriaitinerante.retrofit;
import com.example.reitoriaitinerante.ui.Sugestao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SugestaoAPI {
    @GET("/sugestao/get-all")
    Call<List<Sugestao>> getAllSugestoes();

    @POST("/sugestao/save")
    Call<Sugestao> save(@Body Sugestao sugestao);
}