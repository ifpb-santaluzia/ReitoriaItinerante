package com.example.reitoriaitinerante;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.reitoriaitinerante.retrofit.AlunoAPI;
import com.example.reitoriaitinerante.retrofit.RetrofitService;
import com.example.reitoriaitinerante.retrofit.SugestaoAPI;
import com.example.reitoriaitinerante.ui.Aluno;
import com.example.reitoriaitinerante.ui.Sugestao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdicionarSugestaoActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView escrevaSugestaoText;
    private ArrayList<Sugestao> listaSugestao = new ArrayList<Sugestao>();
    private CheckBox anonimoCheckBox;
    private Button salvarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar_sugestao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();

        spinner = findViewById(R.id.spinnerTopico);
        escrevaSugestaoText = findViewById(R.id.escrevaSugestaoText);
        anonimoCheckBox = findViewById(R.id.anonimoCheckBox);
        salvarButton = findViewById(R.id.salvarButtonSugestao);

        RetrofitService retrofitService = new RetrofitService();
        AlunoAPI alunoAPI = retrofitService.getRetrofit().create(AlunoAPI.class);
        SugestaoAPI sugestaoAPI = retrofitService.getRetrofit().create(SugestaoAPI.class);

        /* salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String topico = spinner.getSelectedItem().toString();
                String conteudo = escrevaSugestaoText.getText().toString();
                boolean anonimo = anonimoCheckBox.isChecked();

                SharedPreferences sharedPreferences = getSharedPreferences(
                        getString(R.string.preference_file_key), Context.MODE_PRIVATE
                );
                alunoAPI.getAllAlunos().enqueue(new Callback<List<Aluno>>() {
                    @Override
                    public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                        String emailPreferences = sharedPreferences.getString("email", "");
                        if (response.isSuccessful()) {
                            List<Aluno> alunosLista = (List<Aluno>) alunoAPI.getAllAlunos();
                            // Percorrendo a lista de alunos

                            for (Aluno aluno : alunosLista) {
                                // Verificar se o email do aluno não é nulo antes de chamar o equals

                                if (aluno.getEmail() != null && aluno.getEmail().equals(emailPreferences)) {
                                    Sugestao sugestao = new Sugestao(conteudo, topico, anonimo, aluno.getIdAluno());
                                    salvarDados(sugestao);
                                    Toast.makeText(getApplicationContext(), "Deu certo paizão!", Toast.LENGTH_SHORT).show();
                                    break; // Para o loop, já que encontrou o aluno correspondente
                                }
                                Toast.makeText(getApplicationContext(), "Deu errado paizão!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Falha ao obter lista de alunos.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Aluno>> call, Throwable throwable) {
                        Toast.makeText(getApplicationContext(), "Falha na chamada de rede.", Toast.LENGTH_LONG).show();
                        Logger.getLogger(AdicionarSugestaoActivity.class.getName()).log(Level.SEVERE, "Erro na chamada", throwable);
                    }
                });

            }
        }); */

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String topico = spinner.getSelectedItem().toString();
                String conteudo = escrevaSugestaoText.getText().toString();
                boolean anonimo = anonimoCheckBox.isChecked();

                if (!conteudo.equals("")) {

                    SharedPreferences sharedPreferences = getSharedPreferences(
                            getString(R.string.preference_file_key), Context.MODE_PRIVATE
                    );

                    String emailPreferences = sharedPreferences.getString("email", "");
                    Log.i("EMAIL",emailPreferences);
                    Aluno aluno = new Aluno("n","","","","","");
                    aluno.setIdAluno(1);
                    Sugestao sugestao = new Sugestao(conteudo, topico, anonimo, 2);
                    sugestao.setAluno(aluno);

                    sugestaoAPI.save(sugestao).enqueue(new Callback<Sugestao>() {
                        @Override
                        public void onResponse(Call<Sugestao> call, Response<Sugestao> response) {
                            Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Sucesso ao salvar!!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Sugestao> call, Throwable throwable) {
                            Toast.makeText(getApplicationContext(), "Falha ao salvar!!", Toast.LENGTH_LONG).show();
                            Logger.getLogger(CadastroActivity.class.getName()).log(Level.SEVERE, "error ocurred", throwable);
                        }

                    });


                } else {
                    Toast.makeText(getApplicationContext(), "Campo obrigatório!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}