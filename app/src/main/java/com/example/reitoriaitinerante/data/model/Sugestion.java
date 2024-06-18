package com.example.reitoriaitinerante.data.model;

public class Sugestion {
private String sugestao;
private String topico;
private boolean anonimo;

public Sugestion(String sugestao, String topico, boolean anonimo) {
    setSugestao(sugestao);
    setTopico(topico);
    setAnonimo(anonimo);
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
}

