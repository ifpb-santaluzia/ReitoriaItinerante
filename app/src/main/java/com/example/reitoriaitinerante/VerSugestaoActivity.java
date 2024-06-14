package com.example.reitoriaitinerante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import java.util.List;

public class VerSugestaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_sugestao);


        recyclerView = findViewById(R.id.recycleView);

        Intent intent = getIntent();

        List<Sugestion> listaSugestion = (List<Sugestion>) getIntent().getSerializableExtra("listaSugestion");



        Adapter adapter = new Adapter(listaSugestion);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }

}