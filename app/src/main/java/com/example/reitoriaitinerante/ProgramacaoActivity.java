package com.example.reitoriaitinerante;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProgramacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao);

        RecyclerView recyclerView = findViewById(R.id.recycleView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> campus = new ArrayList<>();
        campus.add("Campus 1");

        ProgramacaoAdapter programacaoAdapter = new ProgramacaoAdapter(this, campus);
        recyclerView.setAdapter(programacaoAdapter);
    }
}
