package com.example.reitoriaitinerante.retrofit;
import com.example.reitoriaitinerante.ui.Aluno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlunoAPI {
    @GET("/aluno/get-all")
    Call<List<Aluno>> getAllAlunos();

    @POST("aluno/save")
    Call<Aluno> save(@Body Aluno aluno);
}
