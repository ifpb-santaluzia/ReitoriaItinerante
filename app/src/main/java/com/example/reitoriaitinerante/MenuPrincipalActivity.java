package com.example.reitoriaitinerante;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.reitoriaitinerante.ui.Sugestao;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reitoriaitinerante.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipalActivity extends AppCompatActivity {

    private FirebaseAuth autenticador;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private List<Sugestao> listaSugestao = new ArrayList<>();
    private Sugestao sugestao;
    private Button verSugestaoButton;

    private Button verProgramacaoButton;

    private Button adicionarsugestaoButton;
    private TextView nomeTextView;
    private TextView emailTextView;

    private TextView testeTexTView;
    private ImageView photoImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        verSugestaoButton = findViewById(R.id.verSugestaoButton);
        adicionarsugestaoButton = findViewById(R.id.adicionarSugestaoButton);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        //View navView = binding.navView.getHeaderView(0);

        Button logoutButton = navigationView.findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticador.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Logout realizado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent3);
                finish();
            }
        });


        // Recuperando o cabeçalho do NavigationView
        View headerView = navigationView.getHeaderView(0);


        // Buscando os TextView dentro do cabeçalho
        nomeTextView = headerView.findViewById(R.id.nomeTextView);
        emailTextView = headerView.findViewById(R.id.emailTextView);
        photoImageView = headerView.findViewById(R.id.imageView);



        recuperarDados();

        adicionarsugestaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdicionarSugestaoActivity.class);
                startActivity(intent);
            }
        });


        verSugestaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                sugestao = (Sugestao) getIntent().getSerializableExtra("Sugestao");
                listaSugestao.add(sugestao);
                Intent intent1 = new Intent(getApplicationContext(), VerSugestaoActivity.class);
                intent1.putExtra("listaSugestion", (Serializable) listaSugestao);
                startActivity(intent1);
            }
        });

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        drawer = binding.drawerLayout;
        navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu_inicial, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            abrirConfiguracoes();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void abrirConfiguracoes() {
        // Abrir a Activity de Configurações
        Intent intent = new Intent(this, ConfiguracaoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void recuperarDados(){
        SharedPreferences sharedPreferences = getSharedPreferences(
                getString(R.string.preferece_file_key), Context.MODE_PRIVATE
        );

        String nome = sharedPreferences.getString("nome", "");
        String email = sharedPreferences.getString("email", "");
        String photo = sharedPreferences.getString("photo", "");

        nomeTextView.setText(nome);
        emailTextView.setText(email);
        Glide.with(this).load(photo).into(photoImageView);

    }
}