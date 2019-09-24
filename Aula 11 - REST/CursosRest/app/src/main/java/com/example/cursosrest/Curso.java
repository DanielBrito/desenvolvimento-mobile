package com.example.cursosrest;

public class Curso {

    private int id;
    private String nome;
    private String duracao;

    public Curso(int id, String nome, String duracao) {

        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao='" + duracao + '\'' +
                '}';
    }
}