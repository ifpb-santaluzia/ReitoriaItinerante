package com.example.reitoriaitinerante;

import java.io.Serializable;

public class Sugestion implements Serializable {
    private String sugestao;
    private String topico;
    private Boolean anonimo;

    public Sugestion(String sugestao, String topico, Boolean anonimo) {
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
        return "Sugestion{" +
                "sugestao='" + sugestao + '\'' +
                ", topico='" + topico + '\'' +
                ", anonimo=" + anonimo +
                '}';
    }
}