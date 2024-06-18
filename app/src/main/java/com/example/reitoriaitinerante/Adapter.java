package com.example.reitoriaitinerante;



import static java.security.AccessController.getContext;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Sugestion> listaSugestion;

    public Adapter(List<Sugestion> lista) {
        this.listaSugestion = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sugestion sugestion = listaSugestion.get(position);

        if (sugestion.getAnonimo() == true){
            holder.aluno.setText("Anônimo");
        }



        holder.denunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog mDialog = new Dialog(v.getContext());
                mDialog.setContentView(R.layout.popup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button cancelar = mDialog.findViewById(R.id.cancelar_button);
                Button confirmar = mDialog.findViewById(R.id.confirmar_button);

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });

                confirmar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int contagemDenuncias = 0;
                        if (contagemDenuncias == 0){
                            contagemDenuncias++;
                            holder.denunciasTextView.setText(contagemDenuncias + "/5");
                        }
                        mDialog.dismiss();
                    }
                });

                mDialog.setCancelable(false);
                mDialog.show();
            }
        });


        holder.titulo.setText(sugestion.getSugestao());
        holder.titulo.setMaxLines(2);
        holder.titulo.setEllipsize(TextUtils.TruncateAt.END);

        Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.gostar_preenchido);
        Drawable drawable2 = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.gostar);

        holder.likeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (holder.likeButton.getBackground() == drawable){
                    holder.likeButton.setBackground(drawable2);
                    int contagemCurtidas = 0;

                    holder.curtidasTextview.setText(String.valueOf(contagemCurtidas));
                } else {
                    holder.likeButton.setBackground(drawable);
                    int contagemCurtidas = 0;
                    contagemCurtidas++;
                    holder.curtidasTextview.setText(String.valueOf(contagemCurtidas));
                }
            }
        });

        holder.readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.titulo.getMaxLines() == 2) {
                    holder.titulo.setMaxLines(Integer.MAX_VALUE);
                    
                    ViewPropertyAnimatorCompat animator2 = ViewCompat.animate(holder.readMoreButton);
                    animator2.rotationX(180f).setDuration(300)
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
        return listaSugestion.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        Button readMoreButton;
        Button denunciar;
        RelativeLayout layout;
        Button likeButton;
        TextView aluno;
        TextView curtidasTextview;
        TextView denunciasTextView;
        TextView titulo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            denunciasTextView = itemView.findViewById(R.id.denuncias);
            denunciar = itemView.findViewById(R.id.denunciar_button);
            layout = itemView.findViewById(R.id.layout1);
            aluno = itemView.findViewById(R.id.aluno);
            curtidasTextview = itemView.findViewById(R.id.curtidas);
            titulo = itemView.findViewById(R.id.titulo2TextView);
            readMoreButton = itemView.findViewById(R.id.read_more_button);
            likeButton = itemView.findViewById(R.id.like_button);
        }
    }
}
