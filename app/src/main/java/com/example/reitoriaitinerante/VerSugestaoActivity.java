package com.example.reitoriaitinerante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.reitoriaitinerante.retrofit.RetrofitService;
import com.example.reitoriaitinerante.retrofit.SugestaoAPI;
import com.example.reitoriaitinerante.ui.Sugestao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerSugestaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VerSugestoesAdapter adapter;
    private RetrofitService retrofitService = new RetrofitService();
    private SugestaoAPI sugestaoAPI = retrofitService.getRetrofit().create(SugestaoAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_sugestao);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Chamar API e carregar os dados no RecyclerView
        carregarSugestoes();
    }

    private void carregarSugestoes() {
        sugestaoAPI.getAllSugestoes().enqueue(new Callback<List<Sugestao>>() {

            @Override
            public void onResponse(Call<List<Sugestao>> call, Response<List<Sugestao>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Sugestao> sugestoes = response.body();
                    adapter = new VerSugestoesAdapter(sugestoes);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(VerSugestaoActivity.this, "Erro ao carregar as sugestões", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Sugestao>> call, Throwable t) {
                Toast.makeText(VerSugestaoActivity.this, "Falha na conexão: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
