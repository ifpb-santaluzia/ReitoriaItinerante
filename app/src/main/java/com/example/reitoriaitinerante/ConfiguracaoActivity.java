package com.example.reitoriaitinerante;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ConfiguracaoActivity extends AppCompatActivity {

    private Switch modoEscuroSwitch;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Carrega o tema salvo
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean("dark_mode", false);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_configuracao);

        modoEscuroSwitch = findViewById(R.id.modoEscuroSwitch);

        // Define o estado inicial do Switch do Modo Escuro
        modoEscuroSwitch.setChecked(isDarkMode);

        modoEscuroSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (isChecked) {
                    // Ativa o modo escuro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean("dark_mode", true);
                } else {
                    // Desativa o modo escuro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean("dark_mode", false);
                }
                editor.apply();
                recreate();
            }
        });
    }
}
