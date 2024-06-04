package com.example.reitoriaitinerante;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class CadastroActivity extends AppCompatActivity {

    private Spinner campusSpinner;
    private Spinner modalidadeSpinner;
    private Spinner turmaSpinner;
    private Spinner cursoSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializando os Spinners
        campusSpinner = findViewById(R.id.campusSpinner);
        modalidadeSpinner = findViewById(R.id.modalidadeSpinner);
        turmaSpinner = findViewById(R.id.turmaSpinner);
        cursoSpinner = findViewById(R.id.cursoSpinner);

        // Configurando o botão de salvar
        Button salvarButton = findViewById(R.id.salvarButton);
        salvarButton.setOnClickListener(v -> salvarDados());

        modalidadeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] array = null;
                ArrayAdapter<String> arrayAdapter;
                switch (modalidadeSpinner.getSelectedItem().toString()){
                    case "Técnico Integrado":
                        array = getResources().getStringArray(R.array.turma_integrado);
                        break;
                    case "Técnico Subsequente":
                        array = getResources().getStringArray(R.array.turma_subsequente);
                        break;
                    default:
                        array = getResources().getStringArray(R.array.opcao_padrao);
                        break;
                }
                arrayAdapter = new ArrayAdapter<String>(
                        getApplicationContext(), android.R.layout.simple_spinner_item, array );
                turmaSpinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void salvarDados() {
        String campus = campusSpinner.getSelectedItem().toString();
        String modalidade = modalidadeSpinner.getSelectedItem().toString();
        String turma = turmaSpinner.getSelectedItem().toString();
        String curso = cursoSpinner.getSelectedItem().toString();
    }
}
