package com.example.reitoriaitinerante;

import android.content.Intent;
import android.os.Bundle;
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
   // private Sugestao sugestao;

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

        spinner = findViewById(R.id.spinner);
        escrevaSugestaoText = findViewById(R.id.escrevaSugestaoText);
        anonimoCheckBox = findViewById(R.id.anonimoCheckBox);
        salvarButton = findViewById(R.id.salvarButton);



        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topico = spinner.getSelectedItem().toString();
                String conteudo = escrevaSugestaoText.getText().toString();
                boolean anonimo;
                Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
                if (anonimoCheckBox.isChecked()) {
                    anonimo = true;
                } else {
                    anonimo = false;
                }
                //String emailDoAluno=
                // encontra alunono banco pelo email
                Aluno aluno = new Aluno("Túlio", "Santa Luzia", "adsdas", "3° ano", "Tecsdf", "tulio@gmail.com");
                aluno.setIdAluno(1);
                Sugestao sugestao = new Sugestao(conteudo, topico, anonimo, aluno);

                if (!conteudo.equals("")){
                    salvarDados(sugestao);
                } else {
                    Toast.makeText(getApplicationContext(), "Não são permitidos campos vazios", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    RetrofitService retrofitService = new RetrofitService();
    SugestaoAPI sugestaoAPI = retrofitService.getRetrofit().create(SugestaoAPI.class);


    // Metodo para salvar os dados dos usuários quando clickar no botão
    private void salvarDados(Sugestao sugestao) {

        sugestaoAPI.save(sugestao).enqueue(new Callback<Sugestao>() {
            @Override
            public void onResponse(Call<Sugestao> call, Response<Sugestao> response) {
                Toast.makeText(getApplicationContext(), "Save successful!!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Sugestao> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Save failed!!", Toast.LENGTH_LONG).show();
                Logger.getLogger(CadastroActivity.class.getName()).log(Level.SEVERE, "error ocurred", throwable);
            }

        });
        Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
        startActivity(intent);

    }
}