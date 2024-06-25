package com.example.reitoriaitinerante;

import java.time.LocalDate;

public class ItemProgramacao {
    private String nomeDoCampus;
    private LocalDate dataEventoAluno;
    private LocalDate dataEventoServidor;

    public ItemProgramacao(String nomeDoCampus, LocalDate dataEventoAluno, LocalDate dataEventoServidor) {
        this.nomeDoCampus = nomeDoCampus;
        this.dataEventoAluno = dataEventoAluno;
        this.dataEventoServidor = dataEventoServidor;
    }

    public String getNomeDoCampus() {
        return nomeDoCampus;
    }

    public void setNomeDoCampus(String nomeDoCampus) {
        this.nomeDoCampus = nomeDoCampus;
    }

    public LocalDate getDataEventoAluno() {
        return dataEventoAluno;
    }

    public void setDataEventoAluno(LocalDate dataEventoAluno) {
        this.dataEventoAluno = dataEventoAluno;
    }

    public LocalDate getDataEventoServidor() {
        return dataEventoServidor;
    }

    public void setDataEventoServidor(LocalDate dataEventoServidor) {
        this.dataEventoServidor = dataEventoServidor;
    }
}
