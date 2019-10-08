package br.ufc.crateus.firebasetest;

public class User {

    public String nome;
    public String username;
    public int idade;

    public User() {
    }

    public User(String nome, String username, int idade) {
        this.nome = nome;
        this.username = username;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }
}
