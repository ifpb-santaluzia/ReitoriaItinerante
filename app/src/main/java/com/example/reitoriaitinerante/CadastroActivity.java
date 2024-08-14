package com.example.reitoriaitinerante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reitoriaitinerante.retrofit.AlunoAPI;
import com.example.reitoriaitinerante.retrofit.RetrofitService;
import com.example.reitoriaitinerante.ui.Aluno;
import com.example.reitoriaitinerante.ui.Sugestao;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private Spinner campusSpinner;
    private Spinner modalidadeSpinner;
    private Spinner turmaSpinner;
    private Spinner cursoSpinner;
    private Button salvarButton;


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
        getSupportActionBar().hide();
        // Inicializando as variaveis
        nomeEditText = findViewById(R.id.nomeEditText);
        campusSpinner = findViewById(R.id.campusSpinner);
        modalidadeSpinner = findViewById(R.id.modalidadeSpinner);
        turmaSpinner = findViewById(R.id.turmaSpinner);
        cursoSpinner = findViewById(R.id.cursoSpinner);
        salvarButton = findViewById(R.id.salvarButton);



        // Configurando o botão de salvar
        salvarButton.setOnClickListener(v -> salvarDados());

        // Filtragem das turmas de acordo com sua modalidade
        modalidadeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] arrayTurma = null;
                ArrayAdapter<String> arrayAdapterTurma;
                String[] arrayCurso = null;
                ArrayAdapter<String> arrayAdapterCurso;
                switch (modalidadeSpinner.getSelectedItem().toString()) {
                    case "Técnico Integrado":
                        arrayTurma = getResources().getStringArray(R.array.turma_integrado);
                        arrayCurso = getResources().getStringArray(R.array.curso_tecnico);
                        turmaSpinner.setEnabled(true);
                        cursoSpinner.setEnabled(true);
                        break;
                    case "Técnico Subsequente":
                        arrayTurma = getResources().getStringArray(R.array.turma_subsequente);
                        arrayCurso = getResources().getStringArray(R.array.curso_tecnico);
                        turmaSpinner.setEnabled(true);
                        cursoSpinner.setEnabled(true);
                        break;
                    case "Superior":
                        arrayTurma = getResources().getStringArray(R.array.turma_superior);
                        arrayCurso = getResources().getStringArray(R.array.curso_superior);
                        turmaSpinner.setEnabled(true);
                        cursoSpinner.setEnabled(true);
                        break;
                    default:
                        arrayTurma = getResources().getStringArray(R.array.opcao_padrao_turma);
                        arrayCurso = getResources().getStringArray(R.array.opcao_padrao_curso);
                        turmaSpinner.setEnabled(false);
                        cursoSpinner.setEnabled(false);
                        break;
                }
                arrayAdapterTurma = new ArrayAdapter<String>(
                        getApplicationContext(), android.R.layout.simple_spinner_item, arrayTurma);
                turmaSpinner.setAdapter(arrayAdapterTurma);
                arrayAdapterCurso = new ArrayAdapter<String>(
                        getApplicationContext(), android.R.layout.simple_spinner_item, arrayCurso);
                cursoSpinner.setAdapter(arrayAdapterCurso);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    RetrofitService retrofitService = new RetrofitService();
    AlunoAPI alunoAPI = retrofitService.getRetrofit().create(AlunoAPI.class);
    // Metodo para salvar os dados dos usuários quando clickar no botão
    private void salvarDados() {

        String nome = nomeEditText.getText().toString().trim();
        String campus = campusSpinner.getSelectedItem().toString();
        String modalidade = modalidadeSpinner.getSelectedItem().toString();
        String turma = turmaSpinner.getSelectedItem().toString();
        String curso = cursoSpinner.getSelectedItem().toString();


        if (!nome.equals("") && !campus.equals("Escolha seu campus") && !modalidade.equals("Escolha sua modalidade") && !turma.equals("Selecione sua turma") && !curso.equals("Selecione um curso")){
            Aluno aluno = new Aluno(nome, campus, modalidade, turma, curso, "mucho texto");

            alunoAPI.save(aluno).enqueue(new Callback<Aluno>() {
                @Override
                public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                    Toast.makeText(getApplicationContext(), "Save successful!!", Toast.LENGTH_LONG).show();

                }
                @Override
                public void onFailure(Call<Aluno> call, Throwable throwable) {
                    Toast.makeText(getApplicationContext(), "Save failed!!", Toast.LENGTH_LONG).show();
                    Logger.getLogger(CadastroActivity.class.getName()).log(Level.SEVERE, "error ocurred", throwable);

                }

            });
            Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
            intent.putExtra(nome, "nome");
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Não é permitido campos vazios", Toast.LENGTH_SHORT).show();
        }


    }
}