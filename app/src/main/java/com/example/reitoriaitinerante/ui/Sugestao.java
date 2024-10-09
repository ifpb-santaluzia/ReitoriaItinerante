package com.example.reitoriaitinerante.ui;

import java.io.Serializable;

public class Sugestao {

    private String conteudo;
    private String topico;
    private boolean anonimo;
    private int idAluno;
    private Aluno aluno;

    public Sugestao(String conteudo, String topico, boolean anonimo, int idAluno, Aluno aluno) {
        this.conteudo = conteudo;
        this.topico = topico;
        this.anonimo = anonimo;
        this.idAluno = idAluno;
        this.aluno =aluno;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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
                "Sugestão: " + conteudo +
                " | Topico: " + topico +
                " | Anônimo: " + anonimo +
                "}";
    }

}
