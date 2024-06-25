package com.example.reitoriaitinerante;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao);

        RecyclerView recyclerView = findViewById(R.id.recycleView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ItemProgramacao> campus = new ArrayList<ItemProgramacao>();
        campus.add(new ItemProgramacao("Campus 1",LocalDate.of(2024, 07, 10), LocalDate.of(2024, 10, 15)));
        campus.add(new ItemProgramacao("Campus 2",LocalDate.of(2024, 07, 20), LocalDate.of(2024, 11, 17)));

        ProgramacaoAdapter programacaoAdapter = new ProgramacaoAdapter(campus);
        recyclerView.setAdapter(programacaoAdapter);
    }
}
