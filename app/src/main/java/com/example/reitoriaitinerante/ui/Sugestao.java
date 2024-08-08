package com.example.reitoriaitinerante.ui;

import java.io.Serializable;

public class Sugestao implements Serializable {
    private String sugestao;
    private String topico;
    private Boolean anonimo;

    public Sugestao(String sugestao, String topico, Boolean anonimo) {
        this.sugestao = sugestao;
        this.topico = topico;
        this.anonimo = anonimo;
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

    public Boolean getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(Boolean anonimo) {
        this.anonimo = anonimo;
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