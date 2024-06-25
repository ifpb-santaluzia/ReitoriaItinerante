package com.example.reitoriaitinerante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgramacaoAdapter extends RecyclerView.Adapter<ProgramacaoAdapter.ProgramacaoViewHolder> {

    private List<String> listaCampus;
    private Context mContext;

    public ProgramacaoAdapter(Context context, List<String> campus) {
        mContext = context;
        listaCampus = campus;
    }

    @NonNull
    @Override
    public ProgramacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_programacao, parent, false);
        return new ProgramacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramacaoViewHolder holder, int position) {
        holder.bind(listaCampus.get(position));
    }

    @Override
    public int getItemCount() {
        return listaCampus.size();
    }

    class ProgramacaoViewHolder extends RecyclerView.ViewHolder {
        Button buttonCampus;
        LinearLayout layoutCampus;

        public ProgramacaoViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonCampus = itemView.findViewById(R.id.buttonCampus);
            layoutCampus = itemView.findViewById(R.id.layoutCampus);

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

        public void bind(String item) {
            // Configure o botão com o texto ou outros dados, se necessário
            buttonCampus.setText(item);
        }
    }
}
