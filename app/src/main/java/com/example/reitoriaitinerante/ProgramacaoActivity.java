package com.example.reitoriaitinerante;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ProgramacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao);

        setupExpandableButton(R.id.buttonAreia, R.id.layoutAreia);
        setupExpandableButton(R.id.buttonCabedelo, R.id.layoutCabedelo);
        setupExpandableButton(R.id.buttonCabedeloCentro, R.id.layoutCabedeloCentro);
        setupExpandableButton(R.id.buttonCajazeiras, R.id.layoutCajazeiras);
        setupExpandableButton(R.id.buttonCampinaGrande, R.id.layoutCampinaGrande);
        setupExpandableButton(R.id.buttonEsperanca, R.id.layoutEsperanca);
        setupExpandableButton(R.id.buttonGuarabira, R.id.layoutGuarabira);
        setupExpandableButton(R.id.buttonItabaiana, R.id.layoutItabaiana);
        setupExpandableButton(R.id.buttonItaporanga, R.id.layoutItaporanga);
        setupExpandableButton(R.id.buttonJoaoPessoa, R.id.layoutJoaoPessoa);
        setupExpandableButton(R.id.buttonMangabeira, R.id.layoutMangabeira);
        setupExpandableButton(R.id.buttonMonteiro, R.id.layoutMonteiro);
        setupExpandableButton(R.id.buttonPatos, R.id.layoutPatos);
        setupExpandableButton(R.id.buttonPedrasFogo, R.id.layoutPedrasFogo);
        setupExpandableButton(R.id.buttonPicui, R.id.layoutPicui);
        setupExpandableButton(R.id.buttonPrincesaIsabel, R.id.layoutPrincesaIsabel);
        setupExpandableButton(R.id.buttonSantaLuzia, R.id.layoutSantaLuzia);
        setupExpandableButton(R.id.buttonSantaRita, R.id.layoutSantaRita);
        setupExpandableButton(R.id.buttonSoledade, R.id.layoutSoledade);
        setupExpandableButton(R.id.buttonSousa, R.id.layoutSousa);


    }

    private void setupExpandableButton(int buttonId, final int layoutId) {
        final Button button = findViewById(buttonId);
        final LinearLayout layout = findViewById(layoutId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout.getVisibility() == View.GONE) {
                    layout.setVisibility(View.VISIBLE);
                } else {
                    layout.setVisibility(View.GONE);
                }
            }
        });
    }
}
