package com.example.reitoriaitinerante.ui;

public class Aluno {
    private String nome;
  private String campus;
  private String modalidade;
  private String turma;
  private String email;
  private String curso;




    public Aluno(String nome, String campus, String modalidade, String turma, String curso, String email) {
        setNome(nome);
        setCampus(campus);
        setModalidade(modalidade);
        setTurma(turma);
        setCurso(curso);
        setEmail(email);
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                ", nome='" + nome + '\'' +
                ", campus='" + campus + '\'' +
                ", modalidade='" + modalidade + '\'' +
                ", turma=" + turma +
                ", email='" + email + '\'' +
                '}';
    }
}
