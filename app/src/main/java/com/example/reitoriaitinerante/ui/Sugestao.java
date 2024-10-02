package com.example.reitoriaitinerante.ui;

import com.example.reitoriaitinerante.retrofit.AlunoAPI;

import java.io.Serializable;

public class Sugestao implements Serializable {


    private String sugestao;
    private String topico;
    private boolean anonimo;
    private int idAluno;
    private Aluno aluno;

    public Sugestao(String sugestao, String topico, boolean anonimo, int idAluno) {
        this.sugestao = sugestao;
        this.topico = topico;
        this.anonimo = anonimo;
        this.idAluno = idAluno;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public String toString() {
        return "Sugestão {" +
                "Sugestão: " + sugestao +
                " | Topico: " + topico +
                " | Anônimo: " + anonimo +
                "}";
    }

}
