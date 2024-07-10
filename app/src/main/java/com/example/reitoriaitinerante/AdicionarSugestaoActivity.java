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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdicionarSugestaoActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView escrevaSugestaoText;
    private List<Sugestao> listaSugestao = new ArrayList<>();
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

        spinner = findViewById(R.id.spinner);
        escrevaSugestaoText = findViewById(R.id.escrevaSugestaoText);
        anonimoCheckBox = findViewById(R.id.anonimoCheckBox);
        salvarButton = findViewById(R.id.salvarButton);



        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topico = spinner.getSelectedItem().toString();
                String sugestao = escrevaSugestaoText.getText().toString();
                boolean anonimo;
                Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
                if (anonimoCheckBox.isChecked()) {
                    anonimo = true;
                } else {
                    anonimo = false;
                }
                Sugestao sugestion = new Sugestao(sugestao, topico, anonimo);
                Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                intent.putExtra("Sugestao", (Serializable) sugestion);
                startActivity(intent);
            }
        });
    }
}