package com.example.reitoriaitinerante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgramacaoAdapter extends RecyclerView.Adapter<ProgramacaoAdapter.ProgramacaoViewHolder> {

    private List<ItemProgramacao> listaDeItensDeProgramacao;

    public ProgramacaoAdapter(List<ItemProgramacao> campus) {

        listaDeItensDeProgramacao = campus;
    }

    @NonNull
    @Override
    public ProgramacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_programacao, parent, false);
        return new ProgramacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramacaoViewHolder holder, int position) {
        ItemProgramacao itemDeProgramacao = listaDeItensDeProgramacao.get(position);
        holder.buttonCampus.setText(itemDeProgramacao.getNomeDoCampus());
        String eventoAluno = "Aluno: " + itemDeProgramacao.getDataEventoAluno().toString();
        holder.dataEventoAlunoTextView.setText(eventoAluno);


    }

    @Override
    public int getItemCount() {
        return listaDeItensDeProgramacao.size();
    }

    class ProgramacaoViewHolder extends RecyclerView.ViewHolder {
        private Button buttonCampus;
        private LinearLayout layoutCampus;
        private TextView dataEventoAlunoTextView;

        public ProgramacaoViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonCampus = itemView.findViewById(R.id.buttonCampus);
            layoutCampus = itemView.findViewById(R.id.layoutCampus);
            dataEventoAlunoTextView = itemView.findViewById(R.id.alunoTextView);

            buttonCampus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (layoutCampus.getVisibility() == View.GONE) {
                        layoutCampus.setVisibility(View.VISIBLE);
                    } else {
                        layoutCampus.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}
