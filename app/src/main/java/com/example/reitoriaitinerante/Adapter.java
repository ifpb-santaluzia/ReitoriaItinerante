package com.example.reitoriaitinerante;


import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Sugestion> listaSugetion;

    public Adapter(List<Sugestion> lista) {
        this.listaSugetion = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sugestion sugestion = listaSugetion.get(position);

        holder.titulo.setText(sugestion.getSugestao());
        holder.titulo.setMaxLines(2);
        holder.titulo.setEllipsize(TextUtils.TruncateAt.END);

        holder.readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.titulo.getMaxLines() == 2) {
                    holder.titulo.setMaxLines(Integer.MAX_VALUE);

                    ViewPropertyAnimatorCompat animator = ViewCompat.animate(holder.readMoreButton);
                    animator.rotationX(180f).setDuration(300)
                            .setInterpolator(AnimationUtils.loadInterpolator(holder.itemView.getContext(), android.R.anim.accelerate_decelerate_interpolator))
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    holder.titulo.setMaxLines(Integer.MAX_VALUE);
                                }
                            }).start();

                } else {
                    holder.titulo.setMaxLines(2);

                    ViewPropertyAnimatorCompat animator = ViewCompat.animate(holder.readMoreButton);
                    animator.rotationX(0f).setDuration(300)
                            .setInterpolator(AnimationUtils.loadInterpolator(holder.itemView.getContext(), android.R.anim.accelerate_decelerate_interpolator))
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    holder.titulo.setMaxLines(2);
                                }
                            }).start();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaSugetion.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        Button readMoreButton;
        TextView titulo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.titulo2TextView);
            readMoreButton = itemView.findViewById(R.id.read_more_button);
        }
    }
}
